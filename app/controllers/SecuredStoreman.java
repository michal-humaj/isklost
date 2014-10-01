package controllers;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.user.AuthUser;
import models.User;
import org.json.JSONException;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import views.html.login;

import java.io.IOException;
import java.util.Date;

/**
 * Created by MiHu on 17.7.2014.
 */
public class SecuredStoreman extends Security.Authenticator{

    public static final String STOREMAN_ID = "116064143718081568408"; //xskladnik

    /**
     *
     * @param ctx
     * @return null if there is no user logged in, if tehre is STOREMAN or ADMIN return their ID
     */
    @Override
    public String getUsername(final Http.Context ctx) {
        AuthUser u = PlayAuthenticate.getUser(ctx.session());
        if (u == null) return null;
        if (STOREMAN_ID.equals(u.getId())) {
            return u.getId();
        }
        return SecuredAdmin.getAdminIdIfLoggedIn(ctx);
    }

    @Override
    public Result onUnauthorized(final Http.Context ctx) {
        ctx.flash().put(Application.FLASH_MESSAGE_KEY, "Pre pokračovanie sa prosím prihláste platným Google účtom firmy Klost");
        return redirect(routes.Application.login());
    }
}