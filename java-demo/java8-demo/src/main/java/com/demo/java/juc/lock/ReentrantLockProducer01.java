package com.demo.java.juc.lock;

class ReentrantLockProducer01 {
    private ReentrantLockDepot01 depot;

    public ReentrantLockProducer01(ReentrantLockDepot01 depot) {
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