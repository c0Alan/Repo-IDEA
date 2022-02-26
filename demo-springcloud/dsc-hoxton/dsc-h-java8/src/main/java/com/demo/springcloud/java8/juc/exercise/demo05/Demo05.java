package com.demo.springcloud.java8.juc.exercise.demo05;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 多线程分段处理List集合
 * List集合分段,
 * 动态创建线程池newFixedThreadPool
 * 将对比操作在多线程中实现
 *
 * @author liuxilin
 * @date 2018/7/8 15:31
 */
public class Demo05 {
    public static void main(String[] args) throws Exception {
        // 开始时间
        long start = System.currentTimeMillis();
        // 模拟数据List
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 3000; i++) {
            list.add(i + "");
        }
        // 每500条数据开启一条线程
        int threadSize = 500;
        // 总数据条数
        int dataSize = list.size();
        // 线程数
        int threadNum = dataSize / threadSize + 1;
        // 定义标记,过滤threadNum为整数
        boolean special = dataSize % threadSize == 0;
        // 创建一个线程池
        ExecutorService exec = Executors.newFixedThreadPool(threadNum);
        // 定义一个任务集合
        List<Callable<Integer>> tasks = new ArrayList<Callable<Integer>>();
        Callable<Integer> task = null;
        List<String> cutList = null;

        AtomicInteger count = new AtomicInteger(0);
        // 确定每条线程的数据
        for (int i = 0; i < threadNum; i++) {
            if (i == threadNum - 1) {
                if (special) {
                    break;
                }
                cutList = list.subList(threadSize * i, dataSize);
            } else {
                cutList = list.subList(threadSize * i, threadSize * (i + 1));
            }
            // System.out.println("第" + (i + 1) + "组：" + cutList.toString());
            final List<String> listStr = cutList;

            task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    System.out.println(Thread.currentThread().getName() + "线程：" + listStr);
                    return count.addAndGet(1);
                }
            };
            // 这里提交的任务容器列表和返回的Future列表存在顺序对应的关系
            tasks.add(task);
        }
        List<Future<Integer>> results = exec.invokeAll(tasks);
        for (Future<Integer> future : results) {
            System.out.println(future.get());
        }
        // 关闭线程池
        exec.shutdown();
        System.out.println("线程任务执行结束");
        System.err.println("执行任务消耗了 ：" + (System.currentTimeMillis() - start) + "毫秒");
    }
}
