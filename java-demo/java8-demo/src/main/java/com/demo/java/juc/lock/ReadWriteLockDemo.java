package com.demo.java.juc.lock;

/**
 * @author liuxl
 * @date 2024/4/26
 * @description ReentrantReadWriteLock
 */
public class ReadWriteLockDemo {

    public static void main(String[] args) {
        test01();
    }

    /**
     * 同一线程不能同时持有读取锁和写入锁！
     */
    public static void test01() {
        // 创建账户
        ReadWriteLockAccount myCount = new ReadWriteLockAccount("4238920615242830", 10000);
        // 创建用户，并指定账户
        ReadWriteLockUser user = new ReadWriteLockUser("Tommy", myCount);

        // 分别启动3个“读取账户金钱”的线程 和 3个“设置账户金钱”的线程
        for (int i = 0; i < 3; i++) {
            user.getCash();
            user.setCash((i + 1) * 1000);
        }
    }
}