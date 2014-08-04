package models;

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

    @ManyToOne
    public StoredItem item;

    public int amount;
}
