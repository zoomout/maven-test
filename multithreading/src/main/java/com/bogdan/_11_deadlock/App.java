package com.bogdan._11_deadlock;

/**
 * Created by zoomout on 11/21/16.
 * <p>
 * Advanced Java: Multi-threading Part 11 - Dead lock
 * https://www.youtube.com/watch?v=ghCUBi41bGA
 */
public class App {

    public static void main(String[] args) {
        Runner runner = new Runner();
        Thread t1 = new Thread(() -> runner.firstThread());
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