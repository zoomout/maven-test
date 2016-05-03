package com.bogdan.project;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zoomout on 5/2/16.
 */
public class MultiThreading {
    private static final int MYTHREADS = 1;

    public static void main(String args[]) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);
        String[] hostList = {"http://crunchify.com", "http://yahoo.com",
                "http://www.ebay.com", "http://google.com",
                "http://www.example.co",
                "http://google.com",
                "http://bing.com/", "http://techcrunch.com/",
                "http://mashable.com/", "http://thenextweb.com/",
                "http://wordpress.com/", "http://wordpress.org/",
                "http://example.com/", "http://sjsu.edu/",
                "http://ebay.co.uk/", "http://google.co.uk/",
                "http://www.wikipedia.org/",
                "http://www.facebook.org/", "http://google.com",
                "http://bing.com/", "http://techcrunch.com/",
                "http://mashable.com/", "http://thenextweb.com/",
                "http://wordpress.com/", "http://wordpress.org/",
                "http://example.com/", "http://sjsu.edu/",
                "http://ebay.co.uk/", "http://google.co.uk/",
                "http://www.wikipedia.org/",
                "http://www.facebook.org/", "http://google.com",
                "http://bing.com/", "http://techcrunch.com/",
                "http://www.wikipedia.org/",
                "http://www.facebook.org/", "http://google.com",
                "http://bing.com/", "http://techcrunch.com/",
                "http://mashable.com/", "http://thenextweb.com/",
                "http://wordpress.com/", "http://wordpress.org/",
                "http://example.com/", "http://sjsu.edu/",
                "http://ebay.co.uk/", "http://google.co.uk/",
                "http://www.wikipedia.org/",
                "http://www.wikipedia.org/",
                "http://www.facebook.org/", "http://google.com",
                "http://bing.com/", "http://techcrunch.com/",                "http://bing.com/", "http://techcrunch.com/",
                "http://mashable.com/", "http://thenextweb.com/",
                "http://wordpress.com/", "http://wordpress.org/",
                "http://example.com/", "http://sjsu.edu/",
                "http://ebay.co.uk/", "http://google.co.uk/",
                "http://www.wikipedia.org/",
                "http://www.facebook.org/", "http://google.com",
                "http://bing.com/", "http://techcrunch.com/",
                "http://mashable.com/", "http://thenextweb.com/",
                "http://wordpress.com/", "http://wordpress.org/",
                "http://example.com/", "http://sjsu.edu/",
                "http://ebay.co.uk/", "http://google.co.uk/",
                "http://www.wikipedia.org/",
                "http://www.facebook.org/", "http://google.com",
                "http://bing.com/", "http://techcrunch.com/",
                "http://www.wikipedia.org/",
                "http://www.facebook.org/", "http://google.com",
                "http://bing.com/", "http://techcrunch.com/",
                "http://mashable.com/", "http://thenextweb.com/",
                "http://wordpress.com/", "http://wordpress.org/",
                "http://example.com/", "http://sjsu.edu/",
                "http://ebay.co.uk/", "http://google.co.uk/",
                "http://www.wikipedia.org/",
                "http://www.facebook.org/", "http://google.com",
                "http://bing.com/", "http://techcrunch.com/",
                "http://en.wikipedia.org/wiki/Main_Page"};


        System.out.println("Started\n");
        long time = System.currentTimeMillis();
        for (int i = 0; i < hostList.length; i++) {

            String url = hostList[i];
            Runnable worker = new MyRunnable(url);
            executor.execute(worker);
        }
        executor.shutdown();
        // Wait until all threads are finish
        while (!executor.isTerminated()) {

        }
        System.out.println("\nFinished '" + hostList.length + "' threads in " + (System.currentTimeMillis() - time) + " milliseconds");
    }

    public static class MyRunnable implements Runnable {
        private final String url;

        MyRunnable(String url) {
            this.url = url;
        }

        @Override
        public void run() {

            String result = "";
            int code;
            long timeDiff;
            long time = 0;
            try {
                URL siteURL = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) siteURL
                        .openConnection();
                connection.setRequestMethod("GET");
                time = System.currentTimeMillis();
                connection.connect();
                code = connection.getResponseCode();
                if ((code < 400) && (code >= 200)) {
                    result = "Passed";
                }
            } catch (Exception e) {
                result = "Failed";
            } finally {
                timeDiff = System.currentTimeMillis() - time;
            }
            System.out.println("Status: " + result + " Latency: " + timeDiff + "\t\t" + url);
        }
    }

}
