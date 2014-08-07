package models;

import play.i18n.Messages;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by MiHu on 7.8.2014.
 */
public enum EventType {
    ACTION, RESERVATION, SELFTRANSPORT, INSTALLATION;

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<>();
        for(EventType c : EventType.values()) {
            options.put(c.toString(), Messages.get(c.toString()) );
        }
        return options;
    }
}
