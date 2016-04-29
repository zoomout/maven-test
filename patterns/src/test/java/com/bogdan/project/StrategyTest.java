package com.bogdan.project;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class StrategyTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StrategyTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(StrategyTest.class);
    }

    public void testAdd() {
        Context context = new Context(new OperationAdd());
        assertEquals(context.executeStrategy(10, 5), 15);
    }

    public void testSubtract() {
        Context context = new Context(new OperationSubtract());
        assertEquals(context.executeStrategy(10, 5), 5);
    }
    public void testMultiply() {
        Context context = new Context(new OperationMultiply());
        assertEquals(context.executeStrategy(10, 5), 50);
    }
}
