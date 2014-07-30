package models;

import play.data.validation.Constraints.Required;

import javax.persistence.*;
import java.util.List;

/**
 * Created by MiHu on 30.7.2014.
 */
@Entity
public class Tent extends Item {

    @Required
    @OneToMany(cascade = CascadeType.ALL)
    public List<Accessory> accessories;

    public Tent(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public static Finder<Long, Tent> find = new Finder<>(Long.class, Tent.class);
}
