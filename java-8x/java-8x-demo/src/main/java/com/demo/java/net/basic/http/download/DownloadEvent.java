package com.demo.java.net.basic.http.download;

public interface DownloadEvent {
    void percent(long n);

    void state(String s);

    void viewHttpHeaders(String s);
}
