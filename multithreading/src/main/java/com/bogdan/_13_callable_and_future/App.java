package com.bogdan._13_callable_and_future;

import com.bogdan.common.Util;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by zoomout on 11/23/16.
 * <p>
 * Advanced Java: Multi-threading Part 13 - Callable and Future
 * https://www.youtube.com/watch?v=lnbWFV4b7M4
 */
public class App {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(() -> {
            Random random = new Random();
            int duration = random.nextInt(1000);
            if (duration > 500){
                throw new IOException("Sleeping for too long");
            }
            System.out.println("Starting");
            Util.sleep(duration);
            System.out.println("Finished.");
            return duration;
        });

        executor.shutdown();

        try {
            System.out.println("Result is: " + future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }
    }

}
