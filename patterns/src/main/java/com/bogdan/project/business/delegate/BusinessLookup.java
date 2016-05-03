package com.bogdan.project.business.delegate;

/**
 * Created by zoomout on 5/1/16.
 */
public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType) {

        if (serviceType.equalsIgnoreCase("First")) {
            return new FirstService();
        } else {
            return new SecondService();
        }
    }
}
