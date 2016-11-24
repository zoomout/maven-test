package com.bogdan._14_interrupting_threads;

import com.bogdan.common.Util;

import java.util.Random;

/**
 * Created by zoomout on 11/23/16.
 * <p>
 * Advanced Java: Multi-threading Part 13 - Interrupting threads
 * https://www.youtube.com/watch?v=6HydEu75iQI
 */
public class App1 {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting...");
        Thread t = new Thread(() -> {
            Random random = new Random();
            for (int i = 0; i < 1E8; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("We've been interrupted!");
                    break;
                }
                Math.sin(random.nextDouble());
            }
        });
        t.start();
        Util.sleep(500);
        t.interrupt();
        t.join();
        System.out.println("Finished");
    }
}
