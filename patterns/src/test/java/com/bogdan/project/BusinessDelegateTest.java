package com.bogdan.project;

import com.bogdan.project.business.delegate.BusinessDelegate;
import com.bogdan.project.business.delegate.Client;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zoomout on 4/30/16.
 */
public class BusinessDelegateTest {

    BusinessDelegate businessDelegate = new BusinessDelegate();

    @Test
    public void firstService() {
        businessDelegate.setServiceType("First");
        assertEquals(new Client(businessDelegate).doTask(), "First Service");
    }

    @Test
    public void secondService() {
        businessDelegate.setServiceType("Second");
        assertEquals(new Client(businessDelegate).doTask(), "Second Service");
    }
}
