package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.calendar;

/**
 * Created by MiHu on 29.7.2014.
 */
public class Calendar extends Controller {

    public static Result HOME = redirect(routes.Calendar.list());

    public static Result list() {
        return ok(calendar.render());
    }
}
