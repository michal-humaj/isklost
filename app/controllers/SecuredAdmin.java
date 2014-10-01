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

    public static final String ADMIN_ID = "111607400690713539816"; //xhrasko

    /**
     *
     * @param ctx
     * @return null if no user is loged in or loged in user is not admin, user ID otherwise
     */
    @Override
    public String getUsername(final Http.Context ctx) {
        return getAdminIdIfLoggedIn(ctx);
    }

    @Override
    public Result onUnauthorized(final Http.Context ctx) {
        ctx.flash().put(Application.FLASH_MESSAGE_KEY, "Pre pokračovanie sa prosím prihláste platným Google účtom firmy Klost");
        return redirect(routes.Application.login());
    }

    /**
     * if no user is logged in return null
     * if logged user ID is same as ADMIN ID, checks if accesstoken is not older than 1700s
     * if yes, updates accesstoken and
     * return user ID
     * @param ctx
     * @return null if no user is loged in or loged in user is not admin, user ID otherwise
     */
    public static String getAdminIdIfLoggedIn(final Http.Context ctx){
        AuthUser u = PlayAuthenticate.getUser(ctx.session());
        if (u == null) return null;
        if (ADMIN_ID.equals(u.getId())) {
            System.out.println("SECURED ADMIN nech sa paci");
            User user = User.find.ref(u.getId());
            if (new Date().getTime() - user.lastUpdate > 1_700_000){
                System.out.println("--------------------update access token from SecuredAdmin");
                try {
                    user.updateAccessToken();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ctx.session().put("accessToken", user.accessToken);
            }else{
                System.out.println("Secured Admin A sakra POST sa nerobil ubehlo zatial:  " + (new Date().getTime() - user.lastUpdate));
            }
            return u.getId();
        }
        System.out.println("SECURED ADMIN vracia NULL pristup odoporeny");
        return null;
    }
}
