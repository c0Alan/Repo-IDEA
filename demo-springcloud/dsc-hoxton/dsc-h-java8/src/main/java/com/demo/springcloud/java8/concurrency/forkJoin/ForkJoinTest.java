package com.demo.springcloud.java8.concurrency.forkJoin;

import java.util.concurrent.ForkJoinPool;

/**
 * fork-join 框架示例
 *
 * @author liuxilin
 * @date 2022/7/14 22:32
 */
public class ForkJoinTest {

    /**
     * >0.5 的数求和
     * @param args
     */
    public static void main(String[] args) {
        final int SIZE = 10000000;
        double[] numbers = new double[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = Math.random();
        }
        Counter counter = new Counter(numbers, 0, numbers.length, x -> x > 0.5);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter);
        System.out.println(counter.join());
    }
}


