package services;

import com.feth.play.module.pa.providers.oauth2.OAuth2AuthUser;
import com.feth.play.module.pa.service.UserServicePlugin;
import com.feth.play.module.pa.user.AuthUser;
import com.feth.play.module.pa.user.AuthUserIdentity;
import com.feth.play.module.pa.user.EmailIdentity;
import com.feth.play.module.pa.user.NameIdentity;
import models.User;
import play.Application;
import play.mvc.Http;

import java.util.Date;

/**
 * Created by MiHu on 17.7.2014.
 */
public class MyUserServicePlugin extends UserServicePlugin {

    public MyUserServicePlugin(Application app) {
        super(app);
    }

    @Override
    public Object save(AuthUser authUser) {
        System.out.println("SAVE");
        if (authUser instanceof OAuth2AuthUser){
            OAuth2AuthUser oAuth2AuthUser = (OAuth2AuthUser) authUser;
            String accessToken = oAuth2AuthUser.getOAuth2AuthInfo().getAccessToken();
            new User(
                    authUser.getId(),
                    accessToken,
                    oAuth2AuthUser.getOAuth2AuthInfo().getRefreshToken(),
                    new Date().getTime()
            ).save();
            Http.Context.current().session().put("accessToken", accessToken);
        }

        if (authUser instanceof NameIdentity) {
            final NameIdentity identity = (NameIdentity) authUser;
            final String name = identity.getName();
            if (name != null) {
                Http.Context.current().session().put("username", name);
            }
        }
        return authUser;
    }

    @Override
    public AuthUser update(final AuthUser knownUser)
    {
        System.out.println("UPDATE");
        if (knownUser instanceof OAuth2AuthUser){
            OAuth2AuthUser oAuth2AuthUser = (OAuth2AuthUser) knownUser;
            String accessToken = oAuth2AuthUser.getOAuth2AuthInfo().getAccessToken();
            User u = User.find.ref(knownUser.getId());
            u.accessToken = accessToken;
            u.refreshToken = oAuth2AuthUser.getOAuth2AuthInfo().getRefreshToken();
            u.lastUpdate = new Date().getTime();
            u.update();

            Http.Context.current().session().put("accessToken", accessToken);
        }

        if (knownUser instanceof NameIdentity) {
            final NameIdentity identity = (NameIdentity) knownUser;
            final String name = identity.getName();
            if (name != null) {
                Http.Context.current().session().put("username", name);
            }
        }
        return knownUser;
    }

    @Override
    public Object getLocalIdentity(AuthUserIdentity authUserIdentity){
        int a = User.find.where().eq("userId", authUserIdentity.getId()).findRowCount();
        if (a == 1) {
            System.out.println("Get Local Identity returned ID");
            return authUserIdentity.getId();
        }
        System.out.println("Get Local Identity returned NULL");
        return null;
    }

    @Override
    public AuthUser merge(AuthUser authUser, AuthUser authUser2) {
        return null;
    }

    @Override
    public AuthUser link(AuthUser authUser, AuthUser authUser2) {
        return null;
    }


}
