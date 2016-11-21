package com.bogdan._10_re_entrant_locks;

/**
 * Created by zoomout on 11/21/16.
 * <p>
 * Advanced Java: Multi-threading Part 10 - Re-entrant Locks
 * https://www.youtube.com/watch?v=fjMTaVykOpc
 */
public class App {

    public static void main(String[] args) {
        Runner runner = new Runner();
        Thread t1 = new Thread(() -> {
            try {
                runner.firstThread();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        });
        Thread t2 = new Thread(runner::secondThread);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runner.finished();
    }
}