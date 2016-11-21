package com.bogdan._6_countdown_latches;

import com.bogdan.common.Util;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zoomout on 11/21/16.
 *
 * Advanced Java: Multi-threading Part 6 -- Countdown Latches
 * https://www.youtube.com/watch?v=1H-Vfu1v_2g
 */
public class App {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(9);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 9; i++) {
            executor.submit(new Processor(latch));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();

        System.out.println("Completed.");
    }
}

class Processor implements Runnable {
    private CountDownLatch latch;

    Processor(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Started.");
        Util.sleep(1000);
        latch.countDown();
    }
}
