package com.bogdan.web.business.delegate;

/**
 * Created by zoomout on 5/1/16.
 */
public class BusinessDelegate {
    private final BusinessFactory businessFactory = new BusinessFactory();
    private BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }

    public String doTask(){
        businessService = businessFactory.getBusinessService(serviceType);
        return businessService.doProcessing();
    }
}
