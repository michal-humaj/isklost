package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by MiHu on 13.8.2014.
 */
@Entity
public class Installation extends Model {

    @Id
    public String installationId;

    @Required
    public String actionId;

    public Installation(String installationId, String actionId) {
        this.installationId = installationId;
        this.actionId = actionId;
    }

    public static Finder<Long, Installation> find = new Finder<>(Long.class, Installation.class);
}
