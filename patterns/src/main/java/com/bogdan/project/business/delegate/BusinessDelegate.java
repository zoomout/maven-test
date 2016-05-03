package com.bogdan.project.business.delegate;

/**
 * Created by zoomout on 5/1/16.
 */
public class BusinessDelegate {
    private BusinessLookUp lookupService = new BusinessLookUp();
    private BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType){
        this.serviceType = serviceType;
    }

    public String doTask(){
        businessService = lookupService.getBusinessService(serviceType);
        return businessService.doProcessing();
    }
}
