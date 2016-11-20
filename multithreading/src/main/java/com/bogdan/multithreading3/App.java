package com.bogdan.multithreading3;

import com.bogdan.common.Util;

/**
 * Created by zoomout on 11/20/16.
 */
public class App {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello " + i);
                Util.sleep();
            }
        });
        t1.start();
    }
}
