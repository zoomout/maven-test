package com.bogdan._1_multithreading2;

import com.bogdan.common.Util;

/**
 * Created by zoomout on 11/20/16.
 */
public class App {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runner());
        Thread t2 = new Thread(new Runner());

        t1.start();
        t2.start();
    }
}

class Runner implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);
            Util.sleep();
        }
    }
}
