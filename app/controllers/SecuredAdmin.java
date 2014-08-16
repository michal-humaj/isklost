package controllers;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.user.AuthUser;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by MiHu on 17.7.2014.
 */
public class SecuredAdmin extends Security.Authenticator{

    @Override
    public String getUsername(final Http.Context ctx) {
        final AuthUser u = PlayAuthenticate.getUser(ctx.session());
        if (u == null) return null;
        //if ("104577664461666247347".equals(u.getId())) {
        if ("111607400690713539816".equals(u.getId())) {
            return u.getId();
        } else {
            return null;
        }
    }

    @Override
    public Result onUnauthorized(final Http.Context ctx) {
        ctx.flash().put(Application.FLASH_MESSAGE_KEY, "Pre pokračovanie sa prosím prihláste platným Google účtom firmy Klost");
        return redirect(routes.Application.login());
    }
}
