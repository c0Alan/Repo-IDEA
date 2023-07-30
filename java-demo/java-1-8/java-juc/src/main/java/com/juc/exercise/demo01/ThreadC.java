package com.juc.exercise.demo01;

public class ThreadC extends Thread {
    private Subject subject;

    public ThreadC(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            while (!"B".equals(subject.getValue())) {
            }
            // 这里没必要加 synchronized 的必要
//            synchronized (subject){
            System.out.println("C");
            subject.setValue("C");
//            }
        }
    }
}
