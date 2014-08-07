package controllers;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.common.collect.ImmutableMap;
import models.EventType;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.Security;
import views.html.calendar;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import static play.data.Form.form;

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
        DynamicForm eventForm = form().bindFromRequest();

        EventType type = EventType.valueOf(eventForm.get("eventType"));
        String name = eventForm.get("name");

        Event event = new Event().setSummary(name);
        event = setStartEndFromRequest(event, eventForm);

        try {
            insertEvent(event, type);
        } catch (IOException e) {
            return unauthorized(e.getMessage() + " " + e);
        }

        return HOME;
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
}
