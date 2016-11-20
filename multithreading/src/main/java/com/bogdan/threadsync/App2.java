package com.bogdan.threadsync;

/**
 * Created by zoomout on 11/20/16.
 */
public class App2 {

    private int count; // AtomicInteger can be used for synchronisation as well

    public static void main(String[] args) {
        App2 app = new App2();
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
