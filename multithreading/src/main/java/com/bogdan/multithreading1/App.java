package com.bogdan.multithreading1;

import com.bogdan.common.Util;

/**
 * Created by zoomout on 11/20/16.
 * <p>
 * This class is to test multithreading1 in Java
 */
public class App {
    public static void main(String[] args) {
        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();
    }
}

class Runner extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);
            Util.sleep();
        }
    }
}
