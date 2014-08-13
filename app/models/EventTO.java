package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MiHu on 11.8.2014.
 */
public class EventTO {

    public Date startDate;
    public Date endDate;
    public String startTime;
    public String endTime;
    public Boolean allDay;
    public String name;
    public List<EventEntry> entries = new ArrayList<>();


    public EventTO() {
    }

    public EventTO(Date startDate, Date endDate, String startTime, String endTime, Boolean allDay, String name) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.allDay = allDay;
        this.name = name;
    }

    @Override
    public String toString() {
        return "EventTO{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", allDay=" + allDay +
                ", name='" + name + '\'' +
                ", entries=" + entries +
                '}';
    }
}
