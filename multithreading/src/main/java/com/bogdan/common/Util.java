package com.bogdan.common;

import com.bogdan._2_threadsync_volatile.Processor;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;

/**
 * Created by zoomout on 11/20/16.
 */
public class Util {
    public static void sleep() {
        sleep(100);
    }

    public static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitForS(Object o) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Waiting for 's' key");
        String command;
        while (true) {
            command = scanner.nextLine();
            System.out.println("You entered: " + command);
            if ("s".equals(command)) {
                if (o instanceof Condition) {
                    ((Condition) o).signal();
                } else if (o instanceof Processor) {
                    ((Processor) o).shutdown();
                } else {
                    o.notify();
                }
                break;
            } else {
                sleep(50);
            }
        }
    }
}