package com.bogdan._12_semaphores;

import java.util.concurrent.Semaphore;

/**
 * Created by zoomout on 11/22/16.
 * <p>
 * Advanced Java: Multi-threading Part 12 - Semaphores
 * https://www.youtube.com/watch?v=KxTRsvgqoVQ
 */
public class App1 {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);

        printPermits (semaphore);
        semaphore.release();
        printPermits(semaphore);
        semaphore.acquire();
        printPermits(semaphore);

    }

    private static void printPermits(Semaphore semaphore) {
        System.out.println("Available permits: " + semaphore.availablePermits());
    }
}