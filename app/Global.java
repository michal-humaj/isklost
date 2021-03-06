import com.avaje.ebean.Ebean;
import controllers.Cron;
import controllers.Kalendar;
import models.StoredItem;
import play.libs.Yaml;
import play.mvc.Call;
import play.Application;
import play.GlobalSettings;
import play.libs.Akka;
import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.Props;

import com.feth.play.module.pa.PlayAuthenticate;
import com.feth.play.module.pa.PlayAuthenticate.Resolver;
import com.feth.play.module.pa.exceptions.AccessDeniedException;
import com.feth.play.module.pa.exceptions.AuthException;

import controllers.routes;
import play.mvc.Http;
import scala.concurrent.duration.Duration;

import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Global extends GlobalSettings {

    /**
     * sets timezone to default
     * if there are no items in store, loads exapmple items from file to DB
     * setup Cron deleting CARPETS and PBs from store
     * setup Play Authenticate resolver
     * @param app
     */
    public void onStart(final Application app) {

        System.setProperty("user.timezone", "UTC");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        if(Ebean.find(StoredItem.class).findRowCount() == 0) {
            Ebean.save((List) Yaml.load("initial-data.yml"));
        }

        Akka.system().scheduler().schedule(
                Duration.create(20, TimeUnit.MINUTES),
                Duration.create(20, TimeUnit.MINUTES),
                new Cron(),
                Akka.system().dispatcher()
        );

        PlayAuthenticate.setResolver(new Resolver() {

            @Override
            public Call login() {
                // Your login page
                return routes.Application.login();
            }

            @Override
            public Call afterAuth() {
                // The user will be redirected to this page after authentication
                // if no original URL was saved
                return routes.Kalendar.list();
            }

            @Override
            public Call afterLogout() {
                Http.Context.current().flash().put(controllers.Application.FLASH_MESSAGE_KEY, "Ďakujeme za použitie, ste odhlásení");
                return routes.Application.login();
            }

            @Override
            public Call auth(final String provider) {
                // You can provide your own authentication implementation,
                // however the default should be sufficient for most cases
                return com.feth.play.module.pa.controllers.routes.Authenticate
                        .authenticate(provider);
            }

            @Override
            public Call onException(final AuthException e) {
                if (e instanceof AccessDeniedException) {
                    return routes.Application
                            .oAuthDenied(((AccessDeniedException) e)
                                    .getProviderKey());
                }

                // more custom problem handling here...

                return super.onException(e);
            }

            @Override
            public Call askLink() {
                // We don't support moderated account linking in this sample.
                // See the play-authenticate-usage project for an example
                return null;
            }

            @Override
            public Call askMerge() {
                // We don't support moderated account merging in this sample.
                // See the play-authenticate-usage project for an example
                return null;
            }
        });
    }
}