package com.demo.java.java8.juc.pool.executorservice;

public class Thread01 extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " is running.");
    }
}