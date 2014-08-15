package dtos;

import models.EventType;

/**
 * Created by MiHu on 13.8.2014.
 */
public class EventInfoTO {

    public EventType eventType;
    public String id;
    public String name;
    public String start;
    public String end;

    public EventInfoTO() {
    }

    public EventInfoTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public EventInfoTO(EventType eventType, String id) {
        this.eventType = eventType;
        this.id = id;
    }

    public EventInfoTO(EventType eventType, String id, String name, String start, String end) {
        this.eventType = eventType;
        this.id = id;
        this.name = name;
        this.start = start;
        this.end = end;
    }
}
