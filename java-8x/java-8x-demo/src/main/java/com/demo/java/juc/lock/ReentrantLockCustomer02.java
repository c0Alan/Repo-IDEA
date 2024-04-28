package com.demo.java.juc.lock;

class ReentrantLockCustomer02 {
    private ReentrantLockDepot02 depot;

    public ReentrantLockCustomer02(ReentrantLockDepot02 depot) {
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