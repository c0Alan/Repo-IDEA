package com.demo.springcloud.java8.juc.lock.reentrantreadwritelock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class User {
    private String name;            //用户名 
    private MyCount myCount;        //所要操作的账户 
    private ReadWriteLock myLock;   //执行操作所需的锁对象

    User(String name, MyCount myCount) {
        this.name = name;
        this.myCount = myCount;
        this.myLock = new ReentrantReadWriteLock();
    }

    public void getCash() {
        new Thread() {
            public void run() {
                myLock.readLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " getCash start");
                    myCount.getCash();
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " getCash end");
                } catch (InterruptedException e) {
                } finally {
                    myLock.readLock().unlock();
                }
            }
        }.start();
    }

    public void setCash(final int cash) {
        new Thread() {
            public void run() {
                myLock.writeLock().lock();
                try {
                    System.out.println(Thread.currentThread().getName() + " setCash start");
                    myCount.setCash(cash);
                    Thread.sleep(1);
                    System.out.println(Thread.currentThread().getName() + " setCash end");
                } catch (InterruptedException e) {
                } finally {
                    myLock.writeLock().unlock();
                }
            }
        }.start();
    }
}