package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MiHu on 30.7.2014.
 */
@Entity
@DiscriminatorValue("TENT")
public class Tent extends Item {

    @OneToMany(cascade = CascadeType.ALL)
    public List<Accessory> accessories = new ArrayList<>();

    public static Finder<Long, Tent> find = new Finder<>(Long.class, Tent.class);
}
