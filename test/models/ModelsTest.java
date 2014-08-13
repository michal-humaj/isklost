package models;

import com.avaje.ebean.Ebean;
import org.junit.Before;
import org.junit.Test;
import play.libs.Yaml;
import play.test.WithApplication;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;

/**
 * Created by MiHu on 13.8.2014.
 */
public class ModelsTest extends WithApplication {

    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
        Ebean.save((List) Yaml.load("initial-data.yml"));
    }


    @Test
    public void eventEntries() {
        StoredItem i = new StoredItem("hojdacka pre deti", Category.ACCESSORIES, new BigDecimal("15"), new BigDecimal("12.35"));
        i.save();
        System.out.println("-------------------------- " +i.id);
        StoredItem item = StoredItem.find.ref(i.id);

        EventEntry e = new EventEntry("dad1484d8fef3ef@google.com", EventType.ACTION, item, new BigDecimal("14"));
        e.save();
        System.out.println("----------------------------- " + e.id);

        assertEquals(e.item.id, item.id);
    }

}