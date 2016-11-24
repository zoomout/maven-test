package com.bogdan._12_semaphores;

import com.bogdan.common.Util;

import java.util.concurrent.Semaphore;

/**
 * Created by zoomout on 11/23/16.
 */
public class Connection {
    private static Connection instance = new Connection();
    private int connections = 0;
    private Semaphore semaphore = new Semaphore(10, true);

    private Connection() {

    }

    public static Connection getInstance() {
        return instance;
    }

    public void connect() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            doConnect();
        } finally {
            semaphore.release();
        }

    }

    public void doConnect() {
        synchronized (this) {
            connections++;
            System.out.println("Current connections: " + connections);
        }
        Util.sleep(2000);
        synchronized (this) {
            connections--;
            System.out.println("Current connections: " + connections);
        }
    }
}
