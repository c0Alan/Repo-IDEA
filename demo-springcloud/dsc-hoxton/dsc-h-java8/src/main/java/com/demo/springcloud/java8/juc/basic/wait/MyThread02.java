package com.demo.springcloud.java8.juc.basic.wait;

public class MyThread02 extends Thread{

    public MyThread02(String name) {
        super(name);
    }

    public void run() {
//        synchronized(this){
            System.out.println(Thread.currentThread().getName() + " run ");
            // 停 5s。
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }

    }
}