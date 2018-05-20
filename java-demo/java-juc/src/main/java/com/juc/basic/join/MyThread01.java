package com.juc.basic.join;

// 主线程
public class MyThread01 extends Thread {
    public void run() {
        MyThread02 s = new MyThread02();
        s.start();
        try {
            s.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
