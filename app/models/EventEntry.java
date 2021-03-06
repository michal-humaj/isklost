package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import scala.collection.mutable.*;

import javax.persistence.*;
import java.lang.StringBuilder;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;

/**
 * Created by MiHu on 11.8.2014.
 */
@Entity
public class EventEntry extends Model {

    public static final DecimalFormat df;
    static{
        df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Required
    public String eventId;

    @Required
    public EventType eventType;

    @ManyToOne
    public Item item;

    @Required
    @Column(precision = 6, scale = 2)
    public BigDecimal amount;

    public static Finder<Long, EventEntry> find = new Finder<>(Long.class, EventEntry.class);

    public StringBuilder getInfo() {
        StringBuilder s = new StringBuilder(", ").append(df.format(amount));
        if (item instanceof StoredItem && ((StoredItem) item).category.equals(Category.CARPETS)){
            s.append(" m");
        }else{
            s.append(" KS");
        }
        s.append(" ").append(item.name);
        return s;
    }

    public BigDecimal getWeight()    {
        return amount.multiply(item.getWeight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EventEntry)) return false;
        if (!super.equals(o)) return false;

        EventEntry that = (EventEntry) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        return result;
    }
}
