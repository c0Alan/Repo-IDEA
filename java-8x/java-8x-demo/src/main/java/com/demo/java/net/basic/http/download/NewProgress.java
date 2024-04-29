package com.demo.java.net.basic.http.download;


public class NewProgress implements DownloadEvent {
    private long oldPercent = -1;

    public void percent(long n) {
        if (n > oldPercent) {
            System.out.print("[" + String.valueOf(n) + "%]");
            oldPercent = n;
        }
    }

    public void state(String s) {
        System.out.println(s);
    }

    public void viewHttpHeaders(String s) {
        System.out.println(s);
    }
}