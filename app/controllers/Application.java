package controllers;

import models.StoredItem;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
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

    public static Result javascriptRoutes() {
        response().setContentType("text/javascript");
        return ok(
                Routes.javascriptRouter("jsRoutes",
                        routes.javascript.Kalendar.drag(),
                        routes.javascript.Kalendar.create(),
                        routes.javascript.Kalendar.upcomingActions(),
                        routes.javascript.Kalendar.priceOffer(),
                        routes.javascript.Kalendar.contract(),
                        routes.javascript.Kalendar.deleteModal(),
                        routes.javascript.Kalendar.move(),
                        routes.javascript.Kalendar.edit(),
                        routes.javascript.Store.listInCategory(),
                        routes.javascript.Kalendar.toDateEvents(),
                        routes.javascript.Kalendar.sinceNowToDateEvents(),
                        routes.javascript.Store.availability(),
                        routes.javascript.Store.editModal(),
                        routes.javascript.Store.deleteModal(),
                        routes.javascript.Store.increaseModal(),
                        routes.javascript.Store.decreaseModal(),
                        routes.javascript.Store.carpetsPbAvailability()


                )
        );
    }

}
