package com.jd.java8.juc.lock.reentrantlock.demo01;

/**
 * ReentrantLock示例
 * <p>
 * (01) 现实中，仓库的容量不可能为负数。但是，此模型中的仓库容量可以为负数，这与现实相矛盾！
 * (02) 现实中，仓库的容量是有限制的。但是，此模型中的容量确实没有限制的！
 *
 * @author liuxilin
 * @date 2018/5/20 23:03
 */
public class Demo01 {
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