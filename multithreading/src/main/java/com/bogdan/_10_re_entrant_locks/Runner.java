package com.bogdan._10_re_entrant_locks;

import com.bogdan.common.Util;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zoomout on 11/21/16.
 */
class Runner {

    private int count;
    private Lock lock = new ReentrantLock();
    private Condition cond = lock.newCondition();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }

    void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("Waiting...");
        cond.await();
        System.out.println("Woken up!");
        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    void secondThread() {
        Util.sleep(1000);
        lock.lock();

        Util.waitForS(cond);

        try {
            increment();
        } finally {
            lock.unlock();
        }
    }

    void finished() {
        System.out.println("Count: " + count);
    }
}
