package controllers;

import models.EventType;
import play.api.data.Field;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.calendar;

import static play.data.Form.form;

/**
 * Created by MiHu on 29.7.2014.
 */
@Security.Authenticated(SecuredAdmin.class)
public class Calendar extends Controller {

    public static Result HOME = redirect(routes.Calendar.list());

    public static Result list() {
        return ok(calendar.render());
    }

    public static Result create() {
        DynamicForm eventForm = form().bindFromRequest();
        System.out.println("------------------------- " + eventForm);

        EventType type = EventType.valueOf(eventForm.get("eventType"));
        String name = eventForm.get("name");
        boolean allDay = Boolean.getBoolean(eventForm.get("allDay"));


        return play.mvc.Results.TODO;
    }
}
