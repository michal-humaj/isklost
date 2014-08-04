package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * Created by MiHu on 30.7.2014.
 */
@Entity
public class Accessory extends Model {

    @Id
    public Long id;

    @ManyToOne
    public StoredItem item;

    public int amount;
}
