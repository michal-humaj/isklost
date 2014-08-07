package controllers;

import com.avaje.ebean.Ebean;
import models.Accessory;
import models.Tent;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.modals.tentDelete;
import views.html.tent.*;
import views.html.tents;

import java.util.List;

import static play.data.Form.form;


/**
 * Created by MiHu on 30.7.2014.
 */
@Security.Authenticated(SecuredAdmin.class)
public class Tents extends Controller {

    public static Result TENTS_HOME = redirect(routes.Tents.list());

    public static Result list() {
        List<Tent> tentList = Tent.find.all();
        return ok(tents.render(tentList));
    }

    public static Result neu() {
        Form<Tent> tentForm = form(Tent.class);
        return ok(tentNew.render(tentForm));
    }

    public static Result create() {
        Form<Tent> tentForm = form(Tent.class).bindFromRequest();
        final Tent tent = tentForm.get();
        tent.save();
        return TENTS_HOME;
    }

    public static Result edit(long id) {
        Tent tent = Tent.find.ref(id);
        Form<Tent> tentForm = form(Tent.class).fill(tent);
        return ok(tentEdit.render(id, tentForm));
    }


    public static Result update(long id) {
        Form<Tent> tentForm = form(Tent.class).bindFromRequest();
        final Tent tent = tentForm.get();
        tent.save();
        Tent.find.ref(id).delete();
        return TENTS_HOME;
    }

    public static Result deleteModal(long id) {
        Tent tent = Tent.find.ref(id);
        return ok(tentDelete.render(tent));
    }

    public static Result delete(long id) {
        Tent.find.ref(id).delete();
        return TENTS_HOME;
    }
}
