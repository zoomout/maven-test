package com.bogdan._5_thread_pools;

import com.bogdan.common.Util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zoomout on 11/21/16.
 * Advanced Java: Multi-threading Part 5 -- Thread Pools
 * https://www.youtube.com/watch?v=KUdro0G1BV4
 */
public class App {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            executor.submit(new Processor(i));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All tasks completed");
    }
}

class Processor implements Runnable {
    private int id;

    public Processor(int id) {
        this.id = id;
    }

    public void run() {
        System.out.println("Starting: " + id);
        Util.sleep(2000);
        System.out.println("Completed:" + id);
    }
}
