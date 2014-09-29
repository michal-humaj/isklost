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

    public static String getNewAccessToken(String refreshToken){
        try {
            HttpClient httpclient = HttpClients.createDefault();
            HttpPost httppost = new HttpPost("https://accounts.google.com/o/oauth2/token");
            List<NameValuePair> params = new ArrayList<NameValuePair>(4);
            params.add(new BasicNameValuePair("refresh_token", refreshToken));
            params.add(new BasicNameValuePair("client_id", "348319642197-otjpf6153v1mitqtbe11d08r39oc5skq.apps.googleusercontent.com"));
            params.add(new BasicNameValuePair("client_secret", "xmwcMxJ547EMUm3G_MyzQzsr"));
            params.add(new BasicNameValuePair("grant_type", "refresh_token"));
            httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse response = httpclient.execute(httppost);
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
            StringBuilder builder = new StringBuilder();
            for (String line = null; (line = reader.readLine()) != null;) {
                builder.append(line).append("\n");
            }
            JSONTokener tokener = new JSONTokener(builder.toString());
            JSONObject obj = new JSONObject(tokener);
            System.out.println("Ziskany access token jee : " + obj.get("access_token") );
            System.out.println("--------RESPONSE JE " + obj);
            return obj.get("access_token").toString();
        } catch(IOException | JSONException e){
            e.printStackTrace();
            return null;
        }
    }
}
