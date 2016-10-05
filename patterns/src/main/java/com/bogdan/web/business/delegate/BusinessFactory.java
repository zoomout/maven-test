package com.bogdan.web.business.delegate;

/**
 * Created by zoomout on 5/1/16.
 */
@SuppressWarnings("ALL")
public class BusinessFactory {
    public BusinessService getBusinessService(String serviceType) {

        if (serviceType.equalsIgnoreCase("First")) {
            return new FirstService();
        } else {
            return new SecondService();
        }
    }
}
