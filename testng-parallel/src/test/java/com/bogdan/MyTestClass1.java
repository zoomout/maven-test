package com.bogdan;

import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by zoomout on 5/24/16.
 */
public class MyTestClass1 extends AbstractTest {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AbstractTest.class.getSimpleName());

    private int num;

    @BeforeMethod
    public void beforeMethod() {
        Random random = new Random();
        num = random.nextInt(TIMEOUT);
    }

    @Test
    public void myTestMethod1_1() {
        LOG.info("myTestMethod1_1; sometimes_not_random_num=" + num);
        Sleep.sleep(TIMEOUT);
    }

    @Test
    public void myTestMethod1_2() {
        LOG.info("myTestMethod1_2; sometimes_not_random_num=" + num);
        Sleep.sleep(TIMEOUT);
    }
}
