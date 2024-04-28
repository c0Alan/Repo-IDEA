package com.demo.java.juc.lock;

class ReentrantLockCustomer01 {
    private ReentrantLockDepot01 depot;

    public ReentrantLockCustomer01(ReentrantLockDepot01 depot) {
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