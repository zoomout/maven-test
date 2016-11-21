package com.bogdan._9_low_level_sync;

import com.bogdan.common.Util;

import java.util.LinkedList;
import java.util.Random;

/**
 * Created by zoomout on 11/21/16.
 */
class Processor {

    private LinkedList<Integer> list = new LinkedList<>();
    private static final int LIMIT = 10;
    private final Object lock = new Object();

    void produce() {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (list.size() == LIMIT) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(value++);
            }
        }
    }

    void consume() {
        Random random = new Random();
        while (true) {
            synchronized (lock) {
                while (list.size() == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("List size is: " + list.size());
                int value = list.removeFirst();
                System.out.println("; value is: " + value);
                lock.notify();
            }
            Util.sleep(random.nextInt(1000));
        }
    }
}
