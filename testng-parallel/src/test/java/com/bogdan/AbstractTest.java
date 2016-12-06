package com.bogdan;

import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

/**
 * Created by zoomout on 5/24/16.
 */
public abstract class AbstractTest {

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AbstractTest.class.getSimpleName());

    public static final int TIMEOUT = 1000;

    @BeforeSuite
    public void beforeSuite() {
        LOG.info("BeforeSuite");
    }

    @BeforeTest
    public void beforeTest() {
        LOG.info("BeforeTest");
    }

    @BeforeClass
    public void beforeClass() {
        LOG.info("BeforeClass");
    }

    @BeforeMethod
    public void beforeMethod() {
        LOG.info("BeforeMethod");
    }

    @AfterMethod
    public void afterMethod(ITestResult iTestResult) {
        LOG.info("AfterMethod" + ":" + iTestResult.getName());
    }

    @AfterClass
    public void afterClass() {
        LOG.info("AfterClass");
    }

    @AfterTest
    public void afterTest() {
        LOG.info("AfterTest");
    }

    @AfterSuite
    public void afterSuite() {
        LOG.info("AfterSuite");
    }

}
