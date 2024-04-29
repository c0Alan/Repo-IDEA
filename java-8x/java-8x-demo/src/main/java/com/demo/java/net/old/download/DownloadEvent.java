package com.demo.java.net.old.download;

public interface DownloadEvent {
    void percent(long n);

    void state(String s);

    void viewHttpHeaders(String s);
}
