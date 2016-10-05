package com.bogdan.web;

import com.bogdan.web.business.delegate.BusinessDelegate;
import com.bogdan.web.business.delegate.Client;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zoomout on 4/30/16.
 */
@SuppressWarnings("ALL")
public class BusinessDelegateTest {

    BusinessDelegate businessDelegate = new BusinessDelegate();

    @Test
    public void firstService() {
        businessDelegate.setServiceType("First");
        Assert.assertEquals(new Client(businessDelegate).doTask(), "First Service");
    }

    @Test
    public void secondService() {
        businessDelegate.setServiceType("Second");
        assertEquals(new Client(businessDelegate).doTask(), "Second Service");
    }
}
