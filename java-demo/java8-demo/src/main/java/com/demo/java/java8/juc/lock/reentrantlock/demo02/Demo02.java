package com.demo.java.java8.juc.lock.reentrantlock.demo02;

/**
 * Subject 去掉锁
 * 将造成仓库数据的错误
 *
 * @author liuxilin
 * @date 2018/5/21 21:56
 */
public class Demo02 {
    public static void main(String[] args) {  
        Depot mDepot = new Depot();
        Producer mPro = new Producer(mDepot);
        Customer mCus = new Customer(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}