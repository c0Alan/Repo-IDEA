package com.demo.java.juc.basics.example01;

/**
 * @author liuxl
 * @date 2024/4/25
 * @description 生产/消费者模型
 */
public class DepotRun {
    public static void main(String[] args) {
        Depot mDepot = new Depot(100);
        Producer mPro = new Producer(mDepot);
        Customer mCus = new Customer(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(300);
    }
}