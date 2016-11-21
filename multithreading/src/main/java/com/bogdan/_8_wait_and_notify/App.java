package com.bogdan._8_wait_and_notify;

/**
 * Created by zoomout on 11/21/16.
 * <p>
 * Advanced Java: Multi-threading Part 8 - Wait and Notify
 * https://www.youtube.com/watch?v=gx_YUORX5vk
 */
public class App {

    public static void main(String[] args) {
        Processor proc = new Processor();
        Thread t1 = new Thread(proc::produce);
        Thread t2 = new Thread(proc::consume);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
