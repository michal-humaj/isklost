package controllers;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.Events;
import com.google.common.collect.ImmutableMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import dtos.EventInfoTO;
import models.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.tz.FixedDateTimeZone;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.Security;
import views.html.calendar;
import views.html.events.eventEdit;
import views.html.events.installationEdit;
import views.html.modals.eventDelete;
import views.html.modals.itemEdit;

import javax.persistence.EntityNotFoundException;
import javax.persistence.OptimisticLockException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static play.data.Form.form;
import static play.libs.Json.toJson;

/**
 * Created by MiHu on 29.7.2014.
 */
@Security.Authenticated(SecuredStoreman.class)
public class Kalendar extends Controller {

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    public static final Map<EventType, String> calIds =  ImmutableMap.of(
            EventType.ACTION, "o776rmha219v92fvejs0hahsso@group.calendar.google.com",
            EventType.RESERVATION, "3jg1lna270kjsjb0jjrhhqo5m8@group.calendar.google.com",
            EventType.INSTALLATION, "gehqh0ptgh0i2hkh3f1l4tlerg@group.calendar.google.com",
            EventType.SELFTRANSPORT, "hq8a7ru1eh0qoj7bpn05amtsg8@group.calendar.google.com"
    );

    public static Result HOME = Results.redirect(routes.Kalendar.list());

    public static Result list() {
        return ok(calendar.render());
    }

    public static Result create() {
        try {
            DynamicForm eventForm = form().bindFromRequest();

            EventType type = EventType.valueOf(eventForm.get("eventType"));
            String name = eventForm.get("name");

            Event event = new Event().setSummary(name);
            event = setStartEndFromRequest(event, eventForm);

            Event createdEvent = insertEvent(event, type);
            if (type.equals(EventType.INSTALLATION)) {
                new Installation(createdEvent.getId(), eventForm.get("actionId")).save();
            }

            return HOME;
        } catch (IOException e) {
            e.printStackTrace();
            return badRequest("NO");
        }
    }

    public static Result drag() {
        try {
            DynamicForm eventForm = form().bindFromRequest();
            String id = eventForm.get("id").split("@")[0];
            EventType type = EventType.valueOf(eventForm.get("eventType"));
            Event event = findEvent(id, type);
            event = setStartEndFromRequest(event, eventForm);
            updateEvent(event, type);
        }catch (IOException e){
            e.printStackTrace();
            return badRequest("NO");
        }
        System.out.println("------------- DRAG OK");
        return ok("OK");
    }

    public static Result edit(String eventType, String id) {
        Form<EventTO> eventForm = null;
        try {
            String parseId = id.split("@")[0];
            EventType type = EventType.valueOf(eventType);
            Event event = findEvent(parseId, type);
            EventTO eventTO = convert(event);
            eventTO.entries = EventEntry.find.where().eq("eventType", type).eq("eventId", parseId).findList();
            if (type.equals(EventType.INSTALLATION)){
                try {
                    final Installation installation = Installation.find.ref(parseId);
                    eventTO.actionId = installation.actionId;
                }catch(EntityNotFoundException e){
                    eventTO.actionId = null;
                }
            }
            eventForm = form(EventTO.class).fill(eventTO);

            if (type.equals(EventType.INSTALLATION)){
                return ok(installationEdit.render(eventType, id, eventForm));
            }else{
                return ok(eventEdit.render(eventType, id, eventForm));
            }
        }catch(IOException e){
            e.printStackTrace();
            return badRequest("NO");
        }
    }

    public static Result storemanEdit(String eventType, String id, String name) {
        String parseId = id.split("@")[0];
        EventType type = EventType.valueOf(eventType);
        EventTO eventTO = new EventTO(null, null, null, null, null, name);
        eventTO.entries = EventEntry.find.where().eq("eventType", type).eq("eventId", parseId).findList();
        Form<EventTO> eventForm = form(EventTO.class).fill(eventTO);
        return ok(views.html.events.storemanEdit.render(eventType, id, eventForm));
    }

    public static Result storemanUpdate(String eventType, String id) throws IOException {
        String parseId = id.split("@")[0];
        EventType type = EventType.valueOf(eventType);
        EventTO eventTO = form(EventTO.class).bindFromRequest().get();
        final List<EventEntry> list = EventEntry.find.where().eq("eventType", type)
                .eq("eventId", parseId)
                .eq("item.category", Category.CARPETS)
                .findList();
        for (EventEntry e: list){
            e.delete();
        }
        for (EventEntry e : eventTO.entries) {
            e.eventId = parseId;
            e.eventType = type;
            e.save();
        }
        Event e = findEvent(parseId, type);
        BigDecimal weight = new BigDecimal("0.00");
        StringBuilder name = new StringBuilder(e.getSummary().split("#")[0]).append(" #");
        final List<EventEntry> entries = EventEntry.find.where().eq("eventType", type).eq("eventId", parseId).findList();
        for(EventEntry entry: entries){
            entry.item = Item.find.ref(entry.item.id);
            name.append(entry.getInfo());
            weight = weight.add(entry.getWeight());
        }
        name.append(" | ").append(EventEntry.df.format(weight)).append(" kg");
        e.setSummary(name.toString());
        updateEvent(e, type);
        return HOME;
    }

    public static Result update(String eventType, String id) {
        try {
            EventTO eventTO = form(EventTO.class).bindFromRequest().get();
            String parseId = id.split("@")[0];
            EventType type = EventType.valueOf(eventType);
            Event event = findEvent(parseId, type);
            updateEvent(setEventFromTO(event, eventTO), type);
            if (type.equals(EventType.INSTALLATION)){
                try{
                    final Installation installation = Installation.find.ref(parseId);
                    installation.delete();
                }catch(OptimisticLockException e){

                }
                new Installation(parseId, eventTO.actionId).save();
            }else {
                final List<EventEntry> entries = EventEntry.find.where().eq("eventType", type).eq("eventId", parseId).findList();
                for (EventEntry e : entries) {
                    e.delete();
                }
                for (EventEntry e : eventTO.entries) {
                    e.eventId = parseId;
                    e.eventType = type;
                    e.save();
                }
            }
        }catch(IOException | ParseException e){
            e.printStackTrace();
            return badRequest("NO");
        }
        return HOME;
    }

    public static Result deleteModal(String eventType, String id) {
        String parseId = id.split("@")[0];
        Event event = null;
        try {
            event = findEvent(parseId, EventType.valueOf(eventType));
        } catch (IOException e) {
            e.printStackTrace();
            return badRequest("NO");
        }
        return ok(eventDelete.render(event.getSummary(), eventType, id));
    }

    public static Result move(String eventType, String id) {
        try {
            String parseId = id.split("@")[0];
            EventType type = EventType.valueOf(eventType);
            EventType to = type.equals(EventType.ACTION) ? EventType.RESERVATION : EventType.ACTION;
            Event event = findEvent(parseId, type);
            calendar()
                .events()
                .move(calIds.get(type), event.getId(), calIds.get(to))
                .setOauthToken(session("accessToken"))
                .execute();
            final List<EventEntry> entries = EventEntry.find.where().eq("eventType", type).eq("eventId", parseId).findList();
            for(EventEntry e: entries){
                e.eventType = to;
                e.update(e.id);
            }
            if (to.equals(EventType.RESERVATION)){
                final List<Installation> installs = Installation.find.where().eq("actionId", event.getId()).findList();
                for (Installation i : installs){
                    i.delete();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
            return badRequest("NO");
        }
        return ok("OK");
    }

    public static Result delete(String eventType, String id){
        try {
            String parseId = id.split("@")[0];
            EventType type = EventType.valueOf(eventType);
            Event event = findEvent(parseId, type);
            calendar()
                    .events()
                    .delete(calIds.get(type), parseId)
                    .setOauthToken(session("accessToken"))
                    .execute();
            if (type.equals(EventType.INSTALLATION)) {
                try {
                    Installation.find.ref(parseId).delete();
                }catch (OptimisticLockException e){
                }
            }else {
                final List<EventEntry> entries = EventEntry.find.where().eq("eventType", type).eq("eventId", parseId).findList();
                for (EventEntry e : entries) {
                    e.delete();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
            return badRequest("NO");
        }
        return HOME;
    }

    public static Result upcomingActions(){
        try {
            List<EventInfoTO> events = new ArrayList<>();
            Events googleEvents = findEvents(EventType.ACTION, new DateTime(new Date()), null);
            for (Event e : googleEvents.getItems()) {
                events.add(new EventInfoTO(e.getId(), e.getSummary().split("#")[0]));
            }
            return ok(toJson(events));
        }catch(IOException e){
            e.printStackTrace();
            return badRequest("NO");
        }
    }

    public static Result toDateEvents(String millis){
        try {
            long findAtMillis = Long.parseLong(millis);
            List<EventInfoTO> events = new ArrayList<>();

            List<Event> instRelatedActions = new ArrayList<>();
            final Set<Event> atDayInstallations = removeNotInDateEvents(findEvents(EventType.INSTALLATION, new DateTime(findAtMillis), new DateTime(findAtMillis + 86_400_000)), findAtMillis);
            for(Event e:atDayInstallations){
                Installation inst;
                Event action;
                try {
                    inst = Installation.find.ref(e.getId());
                    action = findEvent(inst.actionId, EventType.ACTION);
                }catch(EntityNotFoundException ex){
                    continue;
                }
                instRelatedActions.add(action);
            }

            for(EventType eventType : EventType.values()) {
                if(eventType.equals(EventType.INSTALLATION)) continue;
                Set<Event> googleEvents = removeNotInDateEvents(findEvents(eventType, new DateTime(findAtMillis), new DateTime(findAtMillis + 86_400_000)), findAtMillis);
                if(eventType.equals(EventType.ACTION)){
                    googleEvents.addAll(instRelatedActions);
                }
                for (Event e : googleEvents) {
                    String sStart = null;
                    String sEnd = null;
                    if(e.getStart().getDateTime() != null){ //if event is scheduled (not all day)

                        long minMillis;
                        long maxMillis;
                        if(eventType.equals(EventType.ACTION)){//if event is action look for its installations
                            List<Long> startMillis = new ArrayList<>();
                            List<Long> endMillis = new ArrayList<>();
                            List<Installation> installs = Installation.find.where().eq("actionId", e.getId()).findList();
                            for(Installation inst: installs) {
                                Event instEvent = findEvent(inst.installationId, EventType.INSTALLATION);
                                DateTime start = instEvent.getStart().getDateTime();
                                DateTime end = instEvent.getEnd().getDateTime();
                                if (start != null){
                                    startMillis.add(start.getValue());
                                }
                                if (end != null){
                                    endMillis.add(end.getValue());
                                }
                            }
                            startMillis.add(e.getStart().getDateTime().getValue());
                            endMillis.add(e.getEnd().getDateTime().getValue());
                            minMillis = Collections.min(startMillis);
                            maxMillis = Collections.max(endMillis);
                        }else {
                            minMillis = e.getStart().getDateTime().getValue();
                            maxMillis = e.getEnd().getDateTime().getValue();
                        }
                        LocalDate jodaStart = new LocalDate(minMillis + 7_200_000, FixedDateTimeZone.UTC);
                        LocalDate jodaEnd = new LocalDate(maxMillis + 7_200_000, FixedDateTimeZone.UTC);
                        LocalDate jodaFind = new LocalDate(findAtMillis + 7_200_000, FixedDateTimeZone.UTC);
                        if(jodaStart.equals(jodaFind)){
                            LocalTime time = new LocalTime(minMillis + 7_200_000, FixedDateTimeZone.UTC);
                            sStart = time.toString("HH:mm");
                        }
                        if(jodaEnd.equals(jodaFind)){
                            LocalTime time = new LocalTime(maxMillis + 7_200_000, FixedDateTimeZone.UTC);
                            sEnd = time.toString("HH:mm");
                        }
                    }
                    events.add(
                            new EventInfoTO(
                                    eventType,
                                    e.getId(),
                                    e.getSummary().split("#")[0],
                                    sStart,
                                    sEnd
                            )
                    );
                }
            }
            return ok(toJson(events));
        }catch(IOException e){
            e.printStackTrace();
            return badRequest("NO");
        }
    }

    public static Result sinceNowToDateEvents(String millis) throws IOException {
        List<EventInfoTO> events = new ArrayList<>();
        long findMaxMillis = Long.parseLong(millis);
        long findMinMillis = new Date().getTime();

        List<Event> instRelatedActions = new ArrayList<>();
        final List<Event> installs = findEvents(EventType.INSTALLATION, new DateTime(findMinMillis), new DateTime(findMaxMillis)).getItems();
        for(Event e:installs){
            Installation inst;
            Event action;
            try {
                inst = Installation.find.ref(e.getId());
                action = findEvent(inst.actionId, EventType.ACTION);
            }catch(EntityNotFoundException ex){
                continue;
            }
            instRelatedActions.add(action);
        }

        for(EventType eventType : EventType.values()) {
            if(eventType.equals(EventType.INSTALLATION)) continue;
            final Set<Event> googleEvents =
                    new HashSet<>(findEvents(eventType, new DateTime(findMinMillis), new DateTime(findMaxMillis)).getItems());
            if(eventType.equals(EventType.ACTION)){
                googleEvents.addAll(instRelatedActions);
            }
            for (Event e:googleEvents){
                events.add(new EventInfoTO(eventType, e.getId()));
            }
        }
        return ok(toJson(events));
    }

    //---------------------------HELPER METHODS---------------------------------------------

    public static Map<String,String> options() {
        try {
            LinkedHashMap<String,String> options = new LinkedHashMap<>();
            List<EventInfoTO> events = new ArrayList<>();
            Events googleEvents = calendar()
                    .events()
                    .list(calIds.get(EventType.ACTION))
                    .setTimeMin(new DateTime(new Date()))
                    .setOauthToken(session("accessToken"))
                    .execute();
            for (Event e : googleEvents.getItems()) {
                options.put(e.getId(), e.getSummary().split("#")[0]);
            }
            return options;
        }catch(IOException e){
            e.printStackTrace();
            return null;
        }
    }

    private static Calendar calendar() {
        Calendar.Builder builder = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, null);
        return builder.build();
    }

    private static Event insertEvent(Event event, EventType eventType) throws IOException {
        return calendar()
                .events()
                .insert(calIds.get(eventType), event)
                .setOauthToken(session("accessToken"))
                .execute();
    }

    private static Event findEvent(String id, EventType eventType) throws IOException {
        return calendar()
                .events()
                .get(calIds.get(eventType), id)
                .setOauthToken(session("accessToken"))
                .execute();
    }

    private static Events findEvents(EventType type, DateTime timeMin, DateTime timeMax) throws IOException {
        return calendar()
                .events()
                .list(calIds.get(type))
                .setTimeMin(timeMin)
                .setTimeMax(timeMax)
                .setOauthToken(session("accessToken"))
                .execute();
    }

    private static void updateEvent(Event event, EventType eventType) throws IOException {
        event
            .setSequence(calendar()
                    .events()
                    .get(calIds.get(eventType), event.getId())
                    .setOauthToken(session("accessToken"))
                    .execute()
                    .getSequence());
        calendar()
            .events()
            .update(calIds.get(eventType), event.getId(), event)
            .setOauthToken(session("accessToken"))
            .execute();
    }

    private static Event setStartEndFromRequest(Event e, DynamicForm eventForm){
        boolean allDay = Boolean.parseBoolean(eventForm.get("allDay"));
        Long startMillis = Long.parseLong(eventForm.get("startDate"));
        Long endMillis = Long.parseLong(eventForm.get("endDate"));

        EventDateTime eventStart;
        EventDateTime eventEnd;

        if(allDay){
            DateTime start = new DateTime(true, startMillis + 86_400_000, 0);
            DateTime end = new DateTime(true, endMillis + 2 * 86_400_000 , 0);

            eventStart =  new EventDateTime().setDate(start);
            eventEnd = new EventDateTime().setDate(end);
        }else {
            DateTime start = new DateTime(startMillis);
            DateTime end = new DateTime(endMillis);

            eventStart = new EventDateTime().setDateTime(start);
            eventEnd = new EventDateTime().setDateTime(end);
        }
        return e.setStart(eventStart).setEnd(eventEnd);
    }

    private static EventTO convert(Event event){
        EventTO eventTO = new EventTO();
        eventTO.name = event.getSummary().split("#")[0];

        DateTime start;
        DateTime end;

        eventTO.allDay = null == event.getStart().getDateTime() ? true : false;

        if (eventTO.allDay){
            start = event.getStart().getDate();
            end = event.getEnd().getDate();
            eventTO.startDate = new Date(start.getValue());
            eventTO.endDate = new Date(end.getValue() - 86_400_000);
        }else{
            start = event.getStart().getDateTime();
            end = event.getEnd().getDateTime();
            eventTO.startDate = new Date(start.getValue() + 7_200_000);
            eventTO.endDate = new Date(end.getValue() + 7_200_000);
        }
        DateFormat df = new SimpleDateFormat("HH:mm");
        eventTO.startTime = df.format(eventTO.startDate);
        eventTO.endTime = df.format(eventTO.endDate);

        return eventTO;
    }

    private static Event setEventFromTO(Event e, EventTO eventTO) throws ParseException {
        BigDecimal weight = new BigDecimal("0.00");
        StringBuilder name = new StringBuilder(eventTO.name).append(" #");
        for(EventEntry entry: eventTO.entries){
            entry.item = Item.find.ref(entry.item.id);
            name.append(entry.getInfo());
            weight = weight.add(entry.getWeight());
        }
        name.append(" | ").append(EventEntry.df.format(weight)).append(" kg");
        e.setSummary(eventTO.entries.size() == 0 ? eventTO.name : name.toString());
        EventDateTime eventStart;
        EventDateTime eventEnd;

        //allday event
        if (eventTO.allDay != null) {
            DateTime start = new DateTime(true, eventTO.startDate.getTime(), 0);
            DateTime end = new DateTime(true, eventTO.endDate.getTime() + 86_400_000, 0);
            eventStart = new EventDateTime().setDate(start);
            eventEnd = new EventDateTime().setDate(end);
        } else {//day scheduled event
            DateFormat df = new SimpleDateFormat("HH:mm");
            DateTime start = new DateTime(eventTO.startDate.getTime() + df.parse(eventTO.startTime).getTime() - 7_200_000);
            DateTime end = new DateTime(eventTO.endDate.getTime() + df.parse(eventTO.endTime).getTime() - 7_200_000);

            eventStart = new EventDateTime().setDateTime(start);
            eventEnd = new EventDateTime().setDateTime(end);
        }
        return e.setStart(eventStart).setEnd(eventEnd);
    }

    private static Set<Event> removeNotInDateEvents(Events googleEvents, long millis){
        final DateTime dateTime = new DateTime(true, millis + 7_200_000, 0);
        List<Event> events = googleEvents.getItems();
        for (Iterator<Event> iter = events.listIterator(); iter.hasNext(); ) {
            Event e = iter.next();
            if (e.getStart().getDateTime() != null) continue;
            final DateTime eDateTime = e.getEnd().getDate();
            if(eDateTime.equals(dateTime)) {
                iter.remove();
            }
        }
        return new HashSet(events);
    }

    public static Result priceOffer(String eventType, String id) {
        String parseId = id.split("@")[0];
        EventType type = EventType.valueOf(eventType);
        response().setContentType("application/x-download");
        final List<EventEntry> entries = EventEntry.find.where().eq("eventType", type).eq("eventId", parseId).findList();
        if (type.equals(EventType.SELFTRANSPORT)){
            response().setHeader("Content-disposition", "attachment; filename=ponuka_dasa_VD.xlsx");
            return ok(excel("public/docs/ponuka_dasa_VD.xlsx", entries, 18, 0, 5).toByteArray());
        }else {
            response().setHeader("Content-disposition", "attachment; filename=ponuka_dasa.xlsx");
            return ok(excel("public/docs/ponuka_dasa.xlsx", entries, 18, 0, 5).toByteArray());
        }
    }

    public static Result contract(String eventType, String id) {
        String parseId = id.split("@")[0];
        EventType type = EventType.valueOf(eventType);
        response().setContentType("application/x-download");
        final List<EventEntry> entries = EventEntry.find.where().eq("eventType", type).eq("eventId", parseId).findList();
        if (type.equals(EventType.SELFTRANSPORT)){
            response().setHeader("Content-disposition", "attachment; filename=zmluva-vlastna_doprava.xlsx");
            return ok(excel("public/docs/zmluva-vlastna_doprava.xlsx", entries, 11, 1, 2).toByteArray());
        }else {
            response().setHeader("Content-disposition", "attachment; filename=vykaz_na_akciu_NEW.xlsx");
            return ok(excel("public/docs/vykaz_na_akciu_NEW.xlsx", entries, 9, 0, 5).toByteArray());
        }
    }

    public static ByteArrayOutputStream excel(String fileName, List<EventEntry> entries, int beginRownum, int nameColnum, int amountColnum) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(fileName);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rowCounter = beginRownum;
            for (EventEntry e : entries) {
                XSSFRow row = sheet.getRow(rowCounter);
                XSSFCell cell = row.getCell(nameColnum);
                cell.setCellValue(e.item.name);
                cell = row.getCell(amountColnum);
                cell.setCellValue(EventEntry.df.format(e.amount));
                rowCounter++;
            }
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            workbook.write(out);
            out.close();
            return out;
        } catch (IOException ex) {
            return null;
        }
    }


}
