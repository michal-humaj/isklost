package controllers;

import models.Tent;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.tents;

import java.util.ArrayList;


/**
 * Created by MiHu on 30.7.2014.
 */
public class Tents extends Controller {

    public static Result TENTS_HOME = redirect(routes.Tents.list());

    public static Result list() {
        return ok(tents.render(new ArrayList<Tent>()));
    }
}
