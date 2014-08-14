package models;

import com.avaje.ebean.Ebean;
import com.google.api.client.util.DateTime;
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
        DateTime d = new DateTime(123456l);
        System.out.println(d.getValue());

    }

}