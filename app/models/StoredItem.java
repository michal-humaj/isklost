package models;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * Created by MiHu on 22.7.2014.
 */
@Entity
public class StoredItem extends Item {

    @Required
    public Category category;

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
}
