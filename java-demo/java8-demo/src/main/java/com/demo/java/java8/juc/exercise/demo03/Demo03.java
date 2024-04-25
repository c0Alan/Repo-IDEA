package com.demo.java.java8.juc.exercise.demo03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * N个人围成一圈吃饭，每个人左右手都各有一根筷子，拿起一双筷子才可以吃饭。
 * 请使用多线程模拟。(可以考虑加些限制条件)
 * |人|人|人|人|人|人|人|人|人|人|人 --> 最后一个人对应第一根筷子
 * 题目的关键是线程池的数量要比人数少一, 才能确保不死锁
 * @author liuxilin
 * @date 2018/6/7 22:38
 */
public class Demo03 {

    public static void main(String[] args) {
        int num = 10;
        ExecutorService pool = Executors.newFixedThreadPool(num - 1);
        List<Chopsticks> chopsticksArr = new ArrayList();
        for(int i=0; i<num; i++){
            chopsticksArr.add(new Chopsticks(i));
        }
        for(int i=0; i<num-1; i++){
            Thread t = new Thread(new Person("person" + i, chopsticksArr.get(i), chopsticksArr.get(i + 1)));
            pool.execute(t);
        }
        Thread t = new Thread(new Person("person" + (num - 1), chopsticksArr.get(0), chopsticksArr.get(num-1)));
        pool.execute(t);
        pool.shutdown();
    }

}
