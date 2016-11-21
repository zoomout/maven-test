package com.bogdan._2_threadsync_volatile;

import com.bogdan.common.Util;

/**
 * Created by zoomout on 11/20/16.
 * <p>
 * Advanced Java: Multi-threading Part 2 -- Basic Thread
 * https://www.youtube.com/watch?v=_aNO6x8HXZ0
 */
public class App {
    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Enter 's' to stop...");
        Util.waitForS(proc1);
        Util.sleep(500);
        System.out.println("'App' is stopped");

    }
}

