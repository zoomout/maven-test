package com.bogdan._2_threadsync_volatile;

import com.bogdan.common.Util;

public class Processor extends Thread {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("Hello");
            Util.sleep(500);
        }
    }

    public void shutdown() {
        System.out.println("'Processor' is stopped");
        running = false;
    }
}
