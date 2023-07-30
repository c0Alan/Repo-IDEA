package com.juc.basic.satrt;

public class MyThread01 extends Thread {
    private int ticket = 50;

    public void run() {
        for (int i = 0; i < 50; i++) {
            if (this.ticket > 0) {
                System.out.println(this.getName() + " 卖票：ticket" + this.ticket--);
            }
        }
    }
}