package models;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by MiHu on 30.7.2014.
 */
@Entity
public class Accessory extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Required
    @ManyToOne
    public StoredItem item;

    @Required
    @Min(1)
    public int amount;

    public static Finder<Long, Accessory> find = new Finder<>(Long.class, Accessory.class);
}
