package com.demo.java.juc.basics;

class MyNumber {
    int number;
    volatile int number2;
    public synchronized void addPlusPlus() {
        number++;
    }

    public void addPlusPlus2() {
        number2++;
    }
}
