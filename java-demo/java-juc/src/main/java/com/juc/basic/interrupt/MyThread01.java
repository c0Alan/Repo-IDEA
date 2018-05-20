package com.juc.basic.interrupt;

public class MyThread01 extends Thread {

    public MyThread01(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (!isInterrupted()) {
                Thread.sleep(100); // 休眠100ms
                i++;
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException."); // RUNNABLE
        }
    }
}