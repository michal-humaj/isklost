package models;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

import javax.persistence.*;

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

    @Min(1)
    public int amount;

    @Min(1)
    public int weight;

    public StoredItem(String name, Category category, int weight, int amount) {
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.amount = amount;
    }

    public static Finder<Long, StoredItem> find = new Finder<>(Long.class, StoredItem.class);
}
