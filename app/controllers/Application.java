package controllers;

import models.StoredItem;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

import java.util.List;

import static play.data.Form.form;

public class Application extends Controller {

    public static final String FLASH_MESSAGE_KEY = "message";

    public static Result login() {
        return ok(login.render());
    }

    public static Result oAuthDenied(final String providerKey) {
        com.feth.play.module.pa.controllers.Authenticate.noCache(response());
        flash(FLASH_MESSAGE_KEY, "Pre úspešné prihlásenie musíte akceptovať požadované povolenia");
        return redirect(routes.Application.login());
    }
}
