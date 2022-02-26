package com.demo.springcloud.java8.juc.basic.interrupt;

public class MyThread02 extends Thread {

    public MyThread02(String name) {
        super(name);
    }

    @Override
    public void run() {
        int i = 0;
        while (!isInterrupted()) {
            try {
                Thread.sleep(100); // 休眠100ms, InterruptedException 是这里抛出的
            } catch (InterruptedException ie) {
                System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") catch InterruptedException.");
            }
            i++;
            System.out.println(Thread.currentThread().getName() + " (" + this.getState() + ") loop " + i);
        }
    }
}