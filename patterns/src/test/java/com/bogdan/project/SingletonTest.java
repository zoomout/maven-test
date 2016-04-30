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
        assertEquals(SingleObject.getInstance().getMessage(), "Hi");
    }

    @Test
    public void sameInstanceTest() {
        SingleObject object1 = SingleObject.getInstance();
        SingleObject object2 = SingleObject.getInstance();
        assertEquals(object1, object2);
    }
}
