package controllers;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.user.AuthUser;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import views.html.login;

/**
 * Created by MiHu on 17.7.2014.
 */
public class SecuredStoreman extends Security.Authenticator{

    @Override
    public String getUsername(final Http.Context ctx) {
        final AuthUser u = PlayAuthenticate.getUser(ctx.session());
        if (u.getId().equals("111607400690713539816")) {
            return u.getId();
        } else {
            return null;
        }
    }

    @Override
    public Result onUnauthorized(final Http.Context ctx) {
        ctx.flash().put(Application.FLASH_MESSAGE_KEY, "Nice try, but you need to log in first!");
        //return redirect(routes.Application.index());
        return ok(login.render());
    }
}