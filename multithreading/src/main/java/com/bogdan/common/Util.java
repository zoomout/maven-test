package com.bogdan.common;

/**
 * Created by zoomout on 11/20/16.
 */
public class Util {
    public static void sleep() {
        sleep(100);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
