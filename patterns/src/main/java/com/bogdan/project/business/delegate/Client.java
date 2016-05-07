package com.bogdan.project.business.delegate;

/**
 * Created by zoomout on 5/1/16.
 */
public class Client {

    BusinessDelegate businessDelegate;

    public Client(BusinessDelegate businessDelegate){
        this.businessDelegate = businessDelegate;
    }

    public String doTask(){
        return businessDelegate.doTask();
    }
}
