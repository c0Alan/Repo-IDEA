package com.demo.java.java8.juc.lock.reentrantreadwritelock;

/**
 * “读取锁”用于只读操作，它是“共享锁”，能同时被多个线程获取。
 * “写入锁”用于写入操作，它是“独占锁”，写入锁只能被一个线程锁获取。
 * 注意：不能同时存在读取锁和写入锁！
 * <p>
 * 读读异步, 读写同步, 写写同步
 *
 * @author liuxilin
 * @date 2018/5/23 10:56
 */
public class ReadWriteLockTest1 {

    public static void main(String[] args) {
        // 创建账户
        MyCount myCount = new MyCount("4238920615242830", 10000);
        // 创建用户，并指定账户
        User user = new User("Tommy", myCount);

        // 分别启动3个“读取账户金钱”的线程 和 3个“设置账户金钱”的线程
        for (int i = 0; i < 3; i++) {
            user.getCash();
            user.setCash((i + 1) * 1000);
        }
    }
}

