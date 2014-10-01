package models;


import com.google.common.collect.Sets;
import play.i18n.Messages;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by MiHu on 22.7.2014.
 */
public enum Category {
    TABLES, CHAIRS, COVERS, TARPS, HEATING, LIGHTS, INFLATABLES, FLOORS, ACCESSORIES, TOOLS, BALDACHINS, OTHERS,
    CONSTRUCTIONS, CARPETS, PB, TENTS;

    /**
     *
     * @return categories that can be used for stored items
     */
    public static Map<String,String> storeOptions() {
        return options(Sets.newHashSet(TENTS));
    }

    /**
     *
     * @return all of the categories to include in event
     */
    public static Map<String,String> eventOptions() {
        return options(new HashSet<Category>());
    }

    /**
     *
     * @return categories of items that can be included in tent template
     */
    public static Map<String,String> tentOptions() {
        return options(Sets.newHashSet(PB, TENTS, CARPETS, HEATING));
    }

    /**
     *
     * @param excludedValues
     * @return map of categories and its localized msgs except excluded ones
     */
    private static Map<String,String> options(Set<Category> excludedValues) {
        LinkedHashMap<String,String> options = new LinkedHashMap<>();
        for(Category c : Category.values()) {
            if (excludedValues.contains(c)) continue;
            options.put(c.toString(), Messages.get(c.toString()) );
        }
        return options;
    }
}
