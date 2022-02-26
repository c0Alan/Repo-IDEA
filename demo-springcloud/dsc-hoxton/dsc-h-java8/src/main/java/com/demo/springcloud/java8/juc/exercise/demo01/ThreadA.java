package com.demo.springcloud.java8.juc.exercise.demo01;

import org.apache.commons.lang3.StringUtils;

public class ThreadA extends Thread {
    private Subject subject;

    public ThreadA(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            while (StringUtils.isNotBlank(subject.getValue()) && !"C".equals(subject.getValue())) {

            }
            // 这里没必要加 synchronized 的必要
//            synchronized (subject){
            System.out.println("A");
            subject.setValue("A");
//            }
        }
    }
}
