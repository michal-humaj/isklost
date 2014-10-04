package dtos;

import models.EventType;

import java.util.List;

/**
 * Created by MiHu on 15.8.2014.
 */
public class EventListTO {

    public List<EventType> types; //TODO zmenit na jeden objekt ktory obsahuje id a typ
    public List<String> ids;
}
