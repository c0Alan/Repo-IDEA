package com.juc.basic.satrt;

public class MyRunnable01 implements Runnable {
    private int ticket = 10;

    public void run() {
        for (int i = 0; i < 10; i++) {
            if (this.ticket > 0) {
/*                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                System.out.println(Thread.currentThread().getName() + " 卖票：ticket" + this.ticket--);
            }
        }
    }
}