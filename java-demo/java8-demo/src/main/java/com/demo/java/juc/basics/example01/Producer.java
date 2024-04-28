package com.demo.java.juc.basics.example01;

/**
 * @author liuxl
 * @date 2024/4/25
 * @description 生产者
 */
class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    // 消费产品：新建一个线程向仓库中生产产品。
    public void produce(final int val) {
        new Thread() {
            public void run() {
                depot.produce(val);
            }
        }.start();
    }
}