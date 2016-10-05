package com.bogdan.web.singleton;

/**
 * Created by zoomout on 4/30/16.
 */
public class SingleObject {

    private static SingleObject instance;
    private String msg;

    //make the constructor private so that this class cannot be
    //instantiated
    private SingleObject() {
    }

    //Get the only object available
    public static synchronized SingleObject getInstance() {
        if (instance == null) {
            synchronized (SingleObject.class) {
                if (instance == null) {
                    instance = new SingleObject();
                }
            }
        }
        return instance;
    }

    public String getMessage() {
        if (this.msg == null) {
            return "default";
        } else {
            return this.msg;
        }
    }

    public void setMessage(final String msg) {
        this.msg = msg;
    }

    public void clearMessage() {
        this.msg = null;
    }
}
