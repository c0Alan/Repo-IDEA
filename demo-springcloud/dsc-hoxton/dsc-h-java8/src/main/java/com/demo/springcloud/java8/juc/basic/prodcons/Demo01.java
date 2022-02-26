package com.demo.springcloud.java8.juc.basic.prodcons;

/**
 * 生产/消费者模型
 * <p>
 * (01) 生产者仅仅在仓储未满时候生产，仓满则停止生产。
 * (02) 消费者仅仅在仓储有产品时候才能消费，仓空则等待。
 * (03) 当消费者发现仓储没产品可消费时候会通知生产者生产。
 * (04) 生产者在生产出可消费产品时候，应该通知等待的消费者去消费。
 *
 * @author liuxilin
 * @date 2018/5/20 16:49
 */
public class Demo01 {
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