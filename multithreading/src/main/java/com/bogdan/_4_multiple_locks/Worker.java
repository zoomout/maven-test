package com.bogdan._4_multiple_locks;

import com.bogdan.common.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zoomout on 11/21/16.
 */
class Worker {

    private Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    private void stageOne() {
        Util.sleep(1);
        synchronized (lock1) {
            list1.add(random.nextInt(100));
        }
    }

    private void stageTwo() {
        Util.sleep(1);
        synchronized (lock2) {
            list2.add(random.nextInt(100));
        }
    }

    private void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    void main() {
        System.out.println("Starting...");
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(this::process);
        Thread thread2 = new Thread(this::process);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        System.out.println("List1 size=" + list1.size() + "; List2 size=" + list2.size());
    }
}
