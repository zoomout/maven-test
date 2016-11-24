package com.bogdan._11_deadlock;

import com.bogdan.common.Util;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zoomout on 11/21/16.
 */
class Runner {

    private Account acc1 = new Account();
    private Account acc2 = new Account();

    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    private void acquireLocks(Lock lock1, Lock lock2) {
        while (true) {
            boolean gotLock1 = false;
            boolean gotLock2 = false;
            try {
                gotLock1 = lock1.tryLock();
                gotLock2 = lock2.tryLock();
            } finally {
                if (gotLock1 && gotLock2) {
                    return;
                }
                if (gotLock1) {
                    lock1.unlock();
                }
                if (gotLock2) {
                    lock2.unlock();
                }
            }

            Util.sleep(1);
        }
    }

    void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            acquireLocks(lock1, lock2);
            try {
                Account.transfer(acc1, acc2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    void secondThread() {
        Random random = new Random();
        acquireLocks(lock2, lock1);

        try {
            Account.transfer(acc2, acc1, random.nextInt(100));
        } finally {
            lock1.unlock();
            lock2.unlock();
        }
    }

    void finished() {
        System.out.println("Account 1 balance: " + acc1.getBalance());
        System.out.println("Account 2 balance: " + acc2.getBalance());
        System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
    }
}
