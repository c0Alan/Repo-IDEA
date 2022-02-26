package com.demo.springcloud.java8.juc.exercise.demo01;

public class ThreadB extends Thread {
    private Subject subject;

    public ThreadB(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            while (!"A".equals(subject.getValue())) {

            }
            // 这里没必要加 synchronized 的必要
//            synchronized (subject){
            System.out.println("B");
            subject.setValue("B");
//            }
        }
    }
}
