package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MiHu on 30.7.2014.
 */
@Entity
@DiscriminatorValue("TENT")
public class Tent extends Item {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tent")
    public List<Accessory> accessories = new ArrayList<>();

    public static Finder<Long, Tent> find = new Finder<>(Long.class, Tent.class);

    public Tent() {
        category = Category.TENTS;
    }

    @Override
    public BigDecimal getWeight() {
        BigDecimal ret = new BigDecimal("0.00");
        for(Accessory a: accessories){
            //String s = a.item.name; //TODO pozor na lazy load
            ret = ret.add(a.item.weight.multiply(a.amount));
        }
        return ret;
    }
}
