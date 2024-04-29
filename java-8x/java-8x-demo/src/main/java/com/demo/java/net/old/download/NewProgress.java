package com.demo.java.net.old.download;


public class NewProgress implements DownloadEvent {
    private long oldPercent = -1;

    @Override
    public void percent(long n) {
        if (n > oldPercent) {
            System.out.print("[" + String.valueOf(n) + "%]");
            oldPercent = n;
        }
    }

    @Override
    public void state(String s) {
        System.out.println(s);
    }

    @Override
    public void viewHttpHeaders(String s) {
        System.out.println(s);
    }
}