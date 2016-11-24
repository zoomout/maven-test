package com.bogdan._12_semaphores;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zoomout on 11/23/16.
 * <p>
 * Advanced Java: Multi-threading Part 12 - Semaphores
 * https://www.youtube.com/watch?v=KxTRsvgqoVQ
 */
public class App2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 200; i++) {
            executor.submit(() -> Connection.getInstance().connect());
        }
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
    }
}
