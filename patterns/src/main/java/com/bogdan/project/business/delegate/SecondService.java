package com.bogdan.project.business.delegate;

/**
 * Created by zoomout on 5/1/16.
 */
public class SecondService implements BusinessService {

    @Override
    public String doProcessing() {
        return "Second Service";
    }
}
