package com.bogdan._14_interrupting_threads;

import com.bogdan.common.Util;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by zoomout on 11/23/16.
 * <p>
 * Advanced Java: Multi-threading Part 13 - Interrupting threads
 * https://www.youtube.com/watch?v=6HydEu75iQI
 */
public class App2 {

    public static void main(String[] args) {

        System.out.println("Starting...");

        ExecutorService executor = Executors.newCachedThreadPool();

        Future<Void> future = executor.submit((Callable<Void>) () -> {
            Random random = new Random();
            for (int i = 0; i < 1E8; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("We've been interrupted!");
                    break;
                }
                Math.sin(random.nextDouble());
            }
            return null;
        });
        executor.shutdown();
//        executor.shutdownNow();
        future.cancel(true);
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished");
    }

}
