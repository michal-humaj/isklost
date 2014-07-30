package models;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

import javax.persistence.*;
import java.math.BigDecimal;


/**
 * Created by MiHu on 22.7.2014.
 */
@Entity
public class StoredItem extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Required
    public String name;

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

    public StringBuilder printAmount(){
        return new StringBuilder(String.valueOf(amount)).append(" ks");
    }

    public StringBuilder printWeight(){
        StringBuilder sWeight = new StringBuilder(String.valueOf(weight));
        return sWeight.insert(sWeight.length() - 3,',').append(" kg");
    }

    public static Finder<Long, StoredItem> find = new Finder<>(Long.class, StoredItem.class);
}
