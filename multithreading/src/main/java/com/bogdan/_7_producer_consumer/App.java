package com.bogdan._7_producer_consumer;

import com.bogdan.common.Util;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zoomout on 11/21/16.
 * <p>
 * Advanced Java: Multi-threading Part 7 - Producer-Consumer
 * https://www.youtube.com/watch?v=Vrt5LqpH2D0
 */
public class App {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

    public static void main(String[] args) {
        Thread t1 = new Thread(App::producer);
        Thread t2 = new Thread(App::consumer);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void producer() {
        Random random = new Random();
        while (true) {
            try {
                queue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void consumer() {
        Random random = new Random();

        while (true) {
            Util.sleep(100);
            if (random.nextInt(10) == 0) {
                Integer taken = null;
                try {
                    taken = queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Taken value: " + taken + "; Queus size: " + queue.size());
            }
        }
    }
}
