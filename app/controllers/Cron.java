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
import org.json.JSONException;

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
    private static final Calendar calendar = null;

    static {
        Calendar.Builder builder = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, null);
        Calendar calendar = builder.build();
    }

    /**
     * first check if there are ADMIN credentials in DB
     * if his access token was not renewed more than 1700s updates it
     * finds all ACTIONS and SELF TRANSPORTS currently running
     * for each of them it substract all CARPETS and PBs used in them from the company store     *
     */
    @Override
    public void run() {
        Calendar.Builder builder = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, null);
        Calendar calendar = builder.build();

        System.out.println("---------------- Cron run method");
        if (User.find.where().eq("userId", SecuredAdmin.ADMIN_ID).findRowCount() != 1){
            System.out.println("NENASIEL SOM USERA");
            return;
        }

        User user = User.find.ref(SecuredAdmin.ADMIN_ID);
        if (new Date().getTime() - user.lastUpdate > 1_700_000) {
            System.out.println("------------------------Z Cronu idem robit update user access token");
            try {
                user.updateAccessToken();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        for (EventType type : EventType.values()) { //iterating SELF TRANSPORTS and ACTIONS
            if (type.equals(EventType.INSTALLATION) || type.equals(EventType.RESERVATION)) continue;
            long nowMillis = new Date().getTime();
            Events events = null;
            try {
                events = calendar
                        .events()
                        .list(Kalendar.calIds.get(type))
                        .setTimeMin(new DateTime(nowMillis))
                        .setTimeMax(new DateTime(nowMillis + 300_000)) //looks for events at present moment within range 5 min
                        .setOauthToken(user.accessToken)
                        .execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (Event e : events.getItems()){
                List<EventEntry> eventEntries = EventEntry.find.where()
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
