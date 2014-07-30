package controllers;

import models.Category;
import models.StoredItem;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import play.mvc.Security;
import views.html.store;
import views.html.modals.*;

import java.math.BigDecimal;
import java.util.List;

import static play.data.Form.form;

/**
 * Created by MiHu on 22.7.2014.
 */
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
}