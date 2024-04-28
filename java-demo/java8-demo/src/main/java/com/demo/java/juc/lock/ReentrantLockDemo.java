package com.demo.java.juc.lock;

/**
 * @author liuxl
 * @date 2024/4/26 
 * @description ReentrantLock是一个可重入的互斥锁（同一线程多次获取），又被称为“独占锁”（同一个时间点只能被一个线程锁持有）
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        test02();
    }

    /**
     * 通过Condition去解决“test01”中的两个问题：“仓库的容量不可能为负数”以及“仓库的容量是有限制的”
     */
    public static void test02() {
        ReentrantLockDepot02 mDepot = new ReentrantLockDepot02(100);
        ReentrantLockProducer02 mPro = new ReentrantLockProducer02(mDepot);
        ReentrantLockCustomer02 mCus = new ReentrantLockCustomer02(mDepot);

        mPro.produce(60);
        mPro.produce(120);
        mCus.consume(90);
        mCus.consume(150);
        mPro.produce(110);
        mPro.produce(110);
    }
	
	public static void test01(){
		ReentrantLockDepot01 mDepot = new ReentrantLockDepot01();
        ReentrantLockProducer01 mPro = new ReentrantLockProducer01(mDepot);
        ReentrantLockCustomer01 mCus = new ReentrantLockCustomer01(mDepot);

        mPro.produce(60);
        mCus.consume(90);
        mPro.produce(120);
        mCus.consume(150);
        mPro.produce(110);
	}
}