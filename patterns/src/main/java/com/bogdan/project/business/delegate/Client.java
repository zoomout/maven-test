package com.bogdan.project.business.delegate;

/**
 * Created by zoomout on 5/1/16.
 */
public class Client {

    BusinessDelegate businessService;

    public Client(BusinessDelegate businessService){
        this.businessService  = businessService;
    }

    public String doTask(){
        return businessService.doTask();
    }
}
