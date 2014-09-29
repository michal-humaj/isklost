package controllers;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.Events;
import models.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.avaje.ebean.Expr.eq;

/**
 * Created by MiHu on 19.8.2014.
 */
public class Cron implements Runnable {

    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    private static final JsonFactory JSON_FACTORY = new JacksonFactory();

    @Override
    public void run() {
        System.out.println("---------------- CRON IDE");
        if (User.find.where().eq("userId", SecuredAdmin.ADMIN_ID).findRowCount() != 1){
            System.out.println("NENASIEL SOM USERA");
            return;
        }
        final User user = User.find.ref(SecuredAdmin.ADMIN_ID);
        if (new Date().getTime() - user.lastUpdate > 1_700_000) {
            System.out.println("-------------------******************************************-----Som tu idem robit POST");
            user.accessToken = Application.getNewAccessToken(user.refreshToken);
            user.lastUpdate = new Date().getTime();
            user.update();
        }

        Calendar.Builder builder = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, null);
        Calendar calendar = builder.build();
        for (EventType type : EventType.values()) {
            if (type.equals(EventType.INSTALLATION) || type.equals(EventType.RESERVATION)) {
                continue;
            }
            long nowMillis = new Date().getTime();
            Events events = null;
            try {
                events = calendar
                        .events()
                        .list(Kalendar.calIds.get(type))
                        .setTimeMin(new DateTime(nowMillis))
                        .setTimeMax(new DateTime(nowMillis + 300_000))
                        .setOauthToken(user.accessToken)
                        .execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Event e : events.getItems()){
                final List<EventEntry> eventEntries = EventEntry.find.where()
                        .eq("eventType", type)
                        .eq("eventId", e.getId())
                        .or(eq("item.category", Category.PB), eq("item.category", Category.CARPETS))
                        .findList();
                for(EventEntry entry: eventEntries){
                    StoredItem i = (StoredItem) entry.item;
                    i.amount = i.amount.subtract(entry.amount);
                    i.update();
                    entry.delete();
                }
            }
        }

    }
}
