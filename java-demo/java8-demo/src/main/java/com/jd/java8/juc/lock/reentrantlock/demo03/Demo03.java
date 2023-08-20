package com.jd.java8.juc.lock.reentrantlock.demo03;

/**
 * 通过Condition去解决“示例1”中的两个问题：
 * “仓库的容量不可能为负数”以及“仓库的容量是有限制的”。
 * 
 * @author liuxilin
 * @date 2018/5/21 21:55
 */
public class Demo03 {
    public static void main(String[] args) {
        Depot mDepot = new Depot(100);
        Producer mPro = new Producer(mDepot);
        Customer mCus = new Customer(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
    }
}