package controllers;

import com.avaje.ebean.ExpressionList;
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
import dtos.EventInfoTO;
import models.*;
import play.data.DynamicForm;
import play.data.Form;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.Security;
import views.html.calendar;
import views.html.events.eventEdit;
import views.html.events.installationEdit;
import views.html.modals.eventDelete;
import views.html.modals.itemEdit;

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
@Security.Authenticated(SecuredAdmin.class)
public class Kalendar extends Controller {

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();
    private static final Map<EventType, String> calIds =  ImmutableMap.of(
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
                final Installation installation = Installation.find.ref(parseId);
                eventTO.actionId = installation.actionId;
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

    public static Result update(String eventType, String id) {
        try {
            EventTO eventTO = form(EventTO.class).bindFromRequest().get();
            String parseId = id.split("@")[0];
            EventType type = EventType.valueOf(eventType);
            Event event = findEvent(parseId, type);
            updateEvent(setEventFromTO(event, eventTO), type);
            if (type.equals(EventType.INSTALLATION)){
                final Installation installation = Installation.find.ref(parseId);
                installation.delete();
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
                Installation.find.ref(parseId).delete();
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
            Events googleEvents = calendar()
                    .events()
                    .list(calIds.get(EventType.ACTION))
                    .setTimeMin(new DateTime(new Date()))
                    .setOauthToken(session("accessToken"))
                    .execute();
            for (Event e : googleEvents.getItems()) {
                events.add(new EventInfoTO(e.getId(), e.getSummary().split("#")[0]));
            }
            return ok(toJson(events));
        }catch(IOException e){
            e.printStackTrace();
            return badRequest("NO");
        }
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

            eventTO.startDate = new Date(start.getValue());
            eventTO.endDate = new Date(end.getValue());
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
        e.setSummary(name.toString());
        EventDateTime eventStart;
        EventDateTime eventEnd;

        //allday event
        if (eventTO.allDay != null) {
            DateTime start = new DateTime(true, eventTO.startDate.getTime() + 86_400_000, 0);
            DateTime end = new DateTime(true, eventTO.endDate.getTime() + 2 * 86_400_000, 0);

            eventStart = new EventDateTime().setDate(start);
            eventEnd = new EventDateTime().setDate(end);
        } else {//day scheduled event
            DateFormat df = new SimpleDateFormat("HH:mm");
            DateTime start = new DateTime(eventTO.startDate.getTime() + df.parse(eventTO.startTime).getTime() + 3_600_000);
            DateTime end = new DateTime(eventTO.endDate.getTime() + df.parse(eventTO.endTime).getTime() + 3_600_000);

            eventStart = new EventDateTime().setDateTime(start);
            eventEnd = new EventDateTime().setDateTime(end);
        }
        return e.setStart(eventStart).setEnd(eventEnd);
    }
}
