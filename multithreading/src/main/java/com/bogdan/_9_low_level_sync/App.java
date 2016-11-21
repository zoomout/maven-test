package com.bogdan._9_low_level_sync;

/**
 * Created by zoomout on 11/21/16.
 * <p>
 * Advanced Java: Multi-threading Part 9 - A Worked Example Using Low-Level Synchronization
 * https://www.youtube.com/watch?v=wm1O8EE0X8k
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
