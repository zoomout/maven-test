package com.bogdan.web.business.delegate;

/**
 * Created by zoomout on 5/1/16.
 */
public class FirstService implements BusinessService {

    @Override
    public String doProcessing() {
        return "First Service";
    }
}
