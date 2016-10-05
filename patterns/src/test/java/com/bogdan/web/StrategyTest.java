package com.bogdan.web;


import com.bogdan.web.strategy.Context;
import com.bogdan.web.strategy.OperationAdd;
import com.bogdan.web.strategy.OperationMultiply;
import com.bogdan.web.strategy.OperationSubtract;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Unit test for simple Strategy pattern.
 */
public class StrategyTest {

    @Test
    public void testAdd() {
        Context context = new Context(new OperationAdd());
        assertEquals(context.executeStrategy(10, 5), 15);
    }

    @Test
    public void testSubtract() {
        Context context = new Context(new OperationSubtract());
        assertEquals(context.executeStrategy(10, 5), 5);
    }

    @Test
    public void testMultiply() {
        Context context = new Context(new OperationMultiply());
        assertEquals(context.executeStrategy(10, 5), 50);
    }
}
