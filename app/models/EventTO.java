package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MiHu on 11.8.2014.
 */
public class EventTO {

    public Long startDate;
    public Long endDate;
    public boolean allDay;
    public String name;
    public List<EventEntry> entries = new ArrayList<>();
}
