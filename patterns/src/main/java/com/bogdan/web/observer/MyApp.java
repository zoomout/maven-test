package com.bogdan.web.observer;

public class MyApp {
    public static void main(String[] args) {
        System.out.println("Enter Text: ");
        EventSource eventSource = new EventSource();

        eventSource.addObserver((x, y) -> {
            System.out.println("Received response: " + y);
            if (y.equals("exit")){
                System.exit(0);
            }
        });

        new Thread(eventSource).start();
    }
}
