package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by MiHu on 11.8.2014.
 */
@Entity
public class EventEntry extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Required
    public String eventId;

    @ManyToOne
    public Item item;

    @Required
    @Column(precision = 6, scale = 2)
    public BigDecimal amount;

    public EventEntry(String eventId, Item item, BigDecimal amount) {
        this.eventId = eventId;
        this.item = item;
        this.amount = amount;
    }

    public static Finder<Long, EventEntry> find = new Finder<>(Long.class, EventEntry.class);
}
