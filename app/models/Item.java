package models;

import play.data.format.Formats;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by MiHu on 30.7.2014.
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ITEM_TYPE", discriminatorType=DiscriminatorType.STRING)
public class Item extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Required
    public String name;

    @Required
    public Category category;

    public static Finder<Long, Item> find = new Finder<>(Long.class, Item.class);

    public static Map<String,String> options(String sCat) {
        LinkedHashMap<String, String> options = new LinkedHashMap<>();
        if ("Some(TENTS)".equals(sCat)){
            final List<Tent> items = Tent.find.all();
            for (Tent item : items) {
                options.put(item.id.toString(), item.name);
            }
            return options;
        }else {
            Category category;
            try {
                category = Category.valueOf(sCat.substring(5, sCat.length() - 1));
            } catch (StringIndexOutOfBoundsException | IllegalArgumentException e) {
                return options;
            }
            final List<StoredItem> items = StoredItem.find.where().eq("category", category).findList();
            for (StoredItem item : items) {
                options.put(item.id.toString(), item.name);
            }
            return options;
        }
    }

    public BigDecimal getWeight(){
        return null;
    }
}
