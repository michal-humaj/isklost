package models;

import play.i18n.Messages;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by MiHu on 22.7.2014.
 */
public enum Category {
    TABLES, CHAIRS, COVERS, TARPS, HEATING, LIGHTS, INFLATABLES, FLOORS, ACCESSORIES, TOOLS, BALDACHINS, OTHERS,
    CONSTRUCTIONS, CARPETS, PB, TENTS;

    public static Map<String,String> options() {
        LinkedHashMap<String,String> options = new LinkedHashMap<>();
        for(Category c : Category.values()) {
            switch (c){
                case TENTS: continue;
            }
            options.put(c.toString(), Messages.get(c.toString()) );
        }
        return options;
    }

    public static Map<String,String> eventOptions() {
        LinkedHashMap<String,String> options = new LinkedHashMap<>();
        for(Category c : Category.values()) {
            options.put(c.toString(), Messages.get(c.toString()) );
        }
        return options;
    }

    public static Map<String,String> tentOptions() {
        LinkedHashMap<String,String> options = new LinkedHashMap<>();
        for(Category c : Category.values()) {
            switch (c){
                case PB: continue;
                case TENTS: continue;
                case CARPETS: continue;
                case HEATING: continue;
            }
            options.put(c.toString(), Messages.get(c.toString()) );
        }
        return options;
    }
}
