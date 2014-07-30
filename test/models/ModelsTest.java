package models;

import com.avaje.ebean.Ebean;
import models.*;
import org.junit.*;
import static org.junit.Assert.*;

import play.libs.Yaml;
import play.test.WithApplication;

import java.util.LinkedHashMap;
import java.util.List;

import static play.test.Helpers.*;

/**
 * Created by MiHu on 22.7.2014.
 */
public class ModelsTest extends WithApplication {
    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void createAndRetrieveUser() {
        assertEquals(40, StoredItem.find.findRowCount());
    }
}

