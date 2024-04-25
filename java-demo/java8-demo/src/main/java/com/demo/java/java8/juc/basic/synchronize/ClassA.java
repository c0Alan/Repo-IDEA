package com.demo.java.java8.juc.basic.synchronize;

public class ClassA {
    public ClassB classb;

    public void setClassb(ClassB classb) {
        this.classb = classb;
    }

    synchronized public void methodA(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        classb.methodB();
        System.out.println("a");
    }
}
