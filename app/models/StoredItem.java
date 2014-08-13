package models;

import play.data.validation.Constraints.*;
import scala.reflect.internal.transform.Erasure;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by MiHu on 22.7.2014.
 */
@Entity
@DiscriminatorValue("STORED_ITEM")
public class StoredItem extends Item {

    @Required
    @Column(precision = 6, scale = 2)
    public BigDecimal amount;

    @Required
    @Column(precision = 6, scale = 2)
    public BigDecimal weight;

    public StoredItem(String name, Category category, BigDecimal amount, BigDecimal weight) {
        this.name = name;
        this.category = category;
        this.amount = amount;
        this.weight = weight;
    }

    public static Finder<Long, StoredItem> find = new Finder<>(Long.class, StoredItem.class);

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

    @Override
    public BigDecimal getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "StoredItem{" +
                "name=" + name +
                "category=" + category +
                ", amount=" + amount +
                ", weight=" + weight +
                '}';
    }
}
