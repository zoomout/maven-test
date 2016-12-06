package com.bogdan;

import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by zoomout on 5/24/16.
 *
 */
public class MyTestClass3 extends AbstractTest {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AbstractTest.class.getSimpleName());

    private Map<String, Integer> map = new HashMap<>();

    @BeforeMethod
    public void beforeMethod(Method m) {
        Random random = new Random();
        map.put(m.getName(), random.nextInt(TIMEOUT));
    }

    @Test
    public void myTestMethod3_1(Method m) {
        LOG.info("myTestMethod3_1; random_num=" + map.get(m.getName()));
        Sleep.sleep(TIMEOUT);
    }

    @Test
    public void myTestMethod3_2(Method m) {
        LOG.info("myTestMethod3_2; random_num=" + map.get(m.getName()));
        Sleep.sleep(TIMEOUT);
    }
}
