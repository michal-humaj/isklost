package services;

import com.feth.play.module.pa.providers.oauth2.OAuth2AuthUser;
import com.feth.play.module.pa.service.UserServicePlugin;
import com.feth.play.module.pa.user.AuthUser;
import com.feth.play.module.pa.user.AuthUserIdentity;
import com.feth.play.module.pa.user.EmailIdentity;
import com.feth.play.module.pa.user.NameIdentity;
import play.Application;
import play.mvc.Http;

/**
 * Created by MiHu on 17.7.2014.
 */
public class MyUserServicePlugin extends UserServicePlugin {

    public MyUserServicePlugin(Application app) {
        super(app);
    }

    @Override
    public Object save(AuthUser authUser) {
        return 1L;
    }

    @Override
    public AuthUser update(final AuthUser knownUser)
    {
        if (knownUser instanceof OAuth2AuthUser){
            OAuth2AuthUser oAuth2AuthUser = (OAuth2AuthUser) knownUser;
            String accessToken = oAuth2AuthUser.getOAuth2AuthInfo().getAccessToken();
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
    public Object getLocalIdentity(AuthUserIdentity authUserIdentity) {
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
