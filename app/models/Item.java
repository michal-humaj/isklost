package models;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;

/**
 * Created by MiHu on 30.7.2014.
 */
@MappedSuperclass
public abstract class Item extends Model {

    @Id
    public Long id;

    @Required
    public String name;
}