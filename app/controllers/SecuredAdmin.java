package controllers;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.user.AuthUser;
import com.google.api.client.util.IOUtils;
import models.User;
import org.apache.http.HttpEntity;
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
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MiHu on 17.7.2014.
 */
public class SecuredAdmin extends Security.Authenticator{

    @Override
    public String getUsername(final Http.Context ctx) {
        final AuthUser u = PlayAuthenticate.getUser(ctx.session());
        if (u == null) return null;
        if ("104577664461666247347".equals(u.getId()) || "111607400690713539816".equals(u.getId())) {
            System.out.println("SECURED ADMIN nech sa paci");
            final User user = User.find.ref(u.getId());
            if (new Date().getTime() - user.lastUpdate > 3_500_000){
                System.out.println("-------------------******************************************-----Som tu idem robit POST");
                ctx.session().put("accessToken", Application.getNewAccessToken(user.refreshToken));
                user.lastUpdate = new Date().getTime();
                user.update();
                return u.getId();
            }else{
                System.out.println("A sakra POST sa nerobil ubehlo zatial:  " + (new Date().getTime() - user.lastUpdate));
            }
            return u.getId();
        } else {
            System.out.println("SECURED ADMIN NULL pristup odoporeny");
            return null;
        }
    }

    @Override
    public Result onUnauthorized(final Http.Context ctx) {
        ctx.flash().put(Application.FLASH_MESSAGE_KEY, "Pre pokračovanie sa prosím prihláste platným Google účtom firmy Klost");
        return redirect(routes.Application.login());
    }
}
