package com.demo.springcloud.java8.juc.lock.reentrantreadwritelock;

public class MyCount {
    private String id;         //账号 
    private int cash;       //账户余额

    MyCount(String id, int cash) {
        this.id = id;
        this.cash = cash;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCash() {
        System.out.println(Thread.currentThread().getName() + " getCash cash=" + cash);
        return cash;
    }

    public void setCash(int cash) {
        System.out.println(Thread.currentThread().getName() + " setCash cash=" + cash);
        this.cash = cash;
    }
}