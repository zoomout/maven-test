package com.bogdan.project;

import com.bogdan.project.singleton.SingleObject;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zoomout on 4/30/16.
 */
public class SingletonTest {
    @Test
    public void singletonTest() {
        assertEquals(SingleObject.getInstance().getMessage(), "default");
    }

    @Test
    public void sameInstanceTest() {
        SingleObject object1 = SingleObject.getInstance();
        object1.setMessage("Msg1");
        assertEquals(object1.getMessage(), "Msg1");

        SingleObject object2 = SingleObject.getInstance();
        object1.setMessage("Msg2");

        assertEquals(object1.getMessage(), "Msg2");
        assertEquals(object2.getMessage(), "Msg2");

        object1.clearMessage();
    }
}
