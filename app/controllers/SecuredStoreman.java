package controllers;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.user.AuthUser;
import models.User;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Security;
import views.html.login;

import java.util.Date;

/**
 * Created by MiHu on 17.7.2014.
 */
public class SecuredStoreman extends Security.Authenticator{

    public static final String STOREMAN_ID = "116064143718081568408"; //xskladnik

    @Override
    public String getUsername(final Http.Context ctx) {
        final AuthUser u = PlayAuthenticate.getUser(ctx.session());
        if (u == null) return null;
        if (STOREMAN_ID.equals(u.getId())) {
            return u.getId();
        }
        if (SecuredAdmin.ADMIN_ID.equals(u.getId())) {
            System.out.println("SECURED ADMIN nech sa paci");
            final User user = User.find.ref(u.getId());
            if (new Date().getTime() - user.lastUpdate > 3_500_000){
                System.out.println("-------------------******************************************-----Som tu idem robit POST");
                String accessToken = Application.getNewAccessToken(user.refreshToken);
                ctx.session().put("accessToken",accessToken);
                user.accessToken = accessToken;
                user.lastUpdate = new Date().getTime();
                user.update();
                return u.getId();
            }else{
                System.out.println("A sakra POST sa nerobil ubehlo zatial:  " + (new Date().getTime() - user.lastUpdate));
            }
            return u.getId();
        }
        return null;
    }

    @Override
    public Result onUnauthorized(final Http.Context ctx) {
        ctx.flash().put(Application.FLASH_MESSAGE_KEY, "Nice try, but you need to log in first!");
        //return redirect(routes.Application.index());
        return ok(login.render());
    }
}