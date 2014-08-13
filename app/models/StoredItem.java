package models;

import play.data.validation.Constraints.*;
import scala.reflect.internal.transform.Erasure;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by MiHu on 22.7.2014.
 */
@Entity
@DiscriminatorValue("STORED_ITEM")
public class StoredItem extends Item {

    @Required
    @Column(precision = 6, scale = 2)
    public BigDecimal amount;

    @Required
    @Column(precision = 6, scale = 2)
    public BigDecimal weight;

    public StoredItem(String name, Category category, BigDecimal amount, BigDecimal weight) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.weight = weight;
    }

    public static Finder<Long, StoredItem> find = new Finder<>(Long.class, StoredItem.class);

    @Override
    public BigDecimal getWeight() {
        return weight;
    }
}
