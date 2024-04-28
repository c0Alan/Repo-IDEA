package com.demo.java.juc.basics.example01;

/**
 * @author liuxl
 * @date 2024/4/25
 * @description 消费者
 */
class Customer {
    private Depot depot;

    public Customer(Depot depot) {
        this.depot = depot;
    }

    // 消费产品：新建一个线程从仓库中消费产品。
    public void consume(final int val) {
        new Thread() {
            public void run() {
                depot.consume(val);
            }
        }.start();
    }
}