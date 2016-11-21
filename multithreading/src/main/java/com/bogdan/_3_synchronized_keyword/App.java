package com.bogdan._3_synchronized_keyword;

/**
 * Created by zoomout on 11/20/16.
 *
 * Advanced Java: Multi-threading Part 3 -- The Synchronized Keyword
 * https://www.youtube.com/watch?v=lotAYC3hLVo
 */
public class App {

    private int count; // AtomicInteger can be used for synchronisation as well

    public static void main(String[] args) {
        App app = new App();
        app.doWork();
    }

    public synchronized void increment() {
        count++;
    }

    public void doWork() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Count is: " + count);
    }
}
