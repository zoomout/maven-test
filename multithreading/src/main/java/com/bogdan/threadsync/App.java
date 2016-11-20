package com.bogdan.threadsync;

import com.bogdan.common.Util;

import java.util.Scanner;

/**
 * Created by zoomout on 11/20/16.
 * <p>
 * Thread synchronisation
 */
public class App {
    public static void main(String[] args) {
        Processor proc1 = new Processor();
        proc1.start();

        System.out.println("Enter 's' to stop...");
        Scanner scanner = new Scanner(System.in);
        String command;
        while (true) {
            command = scanner.nextLine();
            System.out.println("You entered: " + command);
            if ("s".equals(command)) {
                proc1.shutdown();
                break;
            }
        }
        Util.sleep(500);
        System.out.println("'App' is stopped");

    }
}

class Processor extends Thread {
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
