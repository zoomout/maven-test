package com.bogdan._8_wait_and_notify;

import com.bogdan.common.Util;

/**
 * Created by zoomout on 11/21/16.
 */
class Processor {

    void produce() {
        synchronized (this) {
            System.out.println("Producer thread running...");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Resumed.");
        }
    }

    void consume() {
        Util.sleep(1000);
        synchronized (this) {
            Util.waitForS(this);
            Util.sleep(1000);
        }
    }
}
