package com.demo.java.java8.juc.exercise.demo02;

/**
 * 三条线程轮流打印 ABCABCABC...
 *
 * @author liuxilin
 * @date 2018/6/1 22:27
 */
public class App {

    public static void main(String[] args) {

        State state= new State();

        Thread t1 = new Thread(new T(state, 0, "A"));
        Thread t2 = new Thread(new T(state, 1, "B"));
        Thread t3 = new Thread(new T(state, 2, "C"));

        t1.start();
        t2.start();
        t3.start();
    }

}