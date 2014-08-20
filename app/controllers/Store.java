package controllers;

import com.avaje.ebean.Expr;
import dtos.AvailTO;
import dtos.EventInfoTO;
import dtos.EventListTO;
import models.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.Security;
import views.html.store;
import views.html.modals.*;

import java.math.BigDecimal;
import java.util.*;

import static com.avaje.ebean.Expr.eq;
import static com.avaje.ebean.Expr.or;
import static play.data.Form.form;
import static play.libs.Json.toJson;

/**
 * Created by MiHu on 22.7.2014.
 */
@Security.Authenticated(SecuredStoreman.class)
public class Store extends Controller {

    public static Result STORE_HOME = redirect(routes.Store.list());

    public static Result list() {
        List<StoredItem> items = StoredItem.find.orderBy("category").findList();
        return ok(store.render(items));
    }

    public static Result newModal() {
        Form<StoredItem> itemForm = form(StoredItem.class);
        return ok(itemNew.render(itemForm));
    }

    public static Result create() {
        StoredItem item = form(StoredItem.class).bindFromRequest().get();
        item.save();
        return STORE_HOME;
    }

    public static Result editModal(long id) {
        StoredItem item = StoredItem.find.ref(id);
        Form<StoredItem> itemForm = form(StoredItem.class).fill(item);
        return ok(itemEdit.render(id, itemForm));
    }

    public static Result update(long id) {
        Form<StoredItem> itemForm = form(StoredItem.class).bindFromRequest();
        itemForm.get().update(id);
        return STORE_HOME;
    }

    public static Result deleteModal(long id) {
        StoredItem item = StoredItem.find.ref(id);
        return ok(itemDelete.render(item));
    }

    public static Result delete(long id) {
        StoredItem.find.ref(id).delete();
        return STORE_HOME;
    }

    public static Result increaseModal(long id) {
        StoredItem item = StoredItem.find.ref(id);
        return ok(itemInc.render(item));
    }

    public static Result increase(long id) {
        DynamicForm data = form().bindFromRequest();
        BigDecimal amount = new BigDecimal(data.get("amount"));
        StoredItem item = StoredItem.find.ref(id);
        item.amount = item.amount.add(amount);
        item.update(id);
        return STORE_HOME;
    }

    public static Result decreaseModal(long id) {
        StoredItem item = StoredItem.find.ref(id);
        return ok(itemDec.render(item));
    }

    public static Result decrease(long id) {
        DynamicForm data = form().bindFromRequest();
        BigDecimal amount = new BigDecimal(data.get("amount"));
        StoredItem item = StoredItem.find.ref(id);
        item.amount = item.amount.subtract(amount);
        item.update(id);
        return STORE_HOME;
    }

    public static Result availability(){
        Map<Long, AvailTO> availMap = new LinkedHashMap<>();// get ready map of all items
        List<StoredItem> items = StoredItem.find.orderBy("category").findList();
        for(StoredItem i: items){
            if(i.category.equals(Category.PB) || i.category.equals(Category.CARPETS)){
                continue;
            }
            availMap.put(i.id, new AvailTO(i.id, i.name, i.category, i.amount, new BigDecimal("0.00"), new BigDecimal("0.00")));
        }
        items = null;

        EventListTO eventList = form(EventListTO.class).bindFromRequest().get();//get ready list with all event entries colliding
        List<EventEntry> entryList = new ArrayList<>();

        for(int i = 0; i < (eventList.ids == null ? 0 : eventList.ids.size()); i++){
            final List<EventEntry> eventEntries = EventEntry.find.where()
                    .eq("eventType", eventList.types.get(i))
                    .eq("eventId", eventList.ids.get(i))
                    .not(or(eq("item.category", Category.PB), eq("item.category", Category.CARPETS)))
                    .findList();
            entryList.addAll(eventEntries);
        }
        eventList = null;

        for(EventEntry e : entryList){
            if(e.item instanceof StoredItem){
                if(e.eventType.equals(EventType.RESERVATION)) {
                    availMap.get(e.item.id).reserve(e.amount);
                }else{
                    availMap.get(e.item.id).rent(e.amount);
                }
            } else if(e.item instanceof Tent){
                Tent t = (Tent) e.item;
                for(Accessory a : t.accessories){
                    if(e.eventType.equals(EventType.RESERVATION)) {
                        availMap.get(a.item.id).reserve(
                                e.amount.multiply(a.amount)
                        );
                    }else{
                        availMap.get(a.item.id).rent(
                            e.amount.multiply(a.amount)
                        );
                    }
                }
            }
        }
        return ok(toJson(availMap.values()));
    }

    public static Result carpetsPbAvailability(){
        Map<Long, AvailTO> availMap = new LinkedHashMap<>();
        List<StoredItem> items = StoredItem.find.where().or(
                eq("category", Category.CARPETS),
                eq("category", Category.PB)
        ).orderBy("category").findList();
        for(StoredItem i: items){
            availMap.put(i.id, new AvailTO(i.id, i.name, i.category, i.amount, new BigDecimal("0.00"), new BigDecimal("0.00")));
        }
        items = null;
        EventListTO eventList = form(EventListTO.class).bindFromRequest().get();//get ready list with all event entries colliding
        Set<EventEntry> entrySet = new HashSet<>();
        for(int i = 0; i < (eventList.ids == null ? 0 : eventList.ids.size()); i++){
            final List<EventEntry> eventEntries = EventEntry.find.where()
                    .eq("eventType", eventList.types.get(i))
                    .eq("eventId", eventList.ids.get(i))
                    .or(eq("item.category", Category.PB), eq("item.category", Category.CARPETS))
                    .findList();
            entrySet.addAll(eventEntries);
        }
        eventList = null;

        for(EventEntry e : entrySet){
            if(e.eventType.equals(EventType.RESERVATION)) {
                availMap.get(e.item.id).reserve(e.amount);
            }else{
                availMap.get(e.item.id).rent(e.amount);
            }
        }
        return ok(toJson(availMap.values()));
    }

    public static Result listInCategory(String sCat) {
        if("TENTS".equals(sCat)){
            final List<Tent> items = Tent.find.all();
            StringBuilder s = new StringBuilder("[");
            if (items.size() == 0){
                return ok("[]").as("application/json");
            }
            for (Tent t: items){
                s.append("{\"id\":").append(t.id)
                    .append(",\"name\":\"").append(t.name).append("\"},");
            }
            s.deleteCharAt(s.length()-1);
            s.append("]");
            return ok(s.toString()).as("application/json");
        }else {
            Category category = Category.valueOf(sCat);
            final List<StoredItem> items = StoredItem.find.where().eq("category", category).findList();
            return ok(toJson(items));
        }
    }
}