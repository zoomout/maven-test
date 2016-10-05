package com.bogdan.web.business.delegate;

/**
 * Created by zoomout on 5/1/16.
 */
public class Client {

    private final BusinessDelegate businessDelegate;

    public Client(BusinessDelegate businessDelegate){
        this.businessDelegate = businessDelegate;
    }

    public String doTask(){
        return businessDelegate.doTask();
    }
}
