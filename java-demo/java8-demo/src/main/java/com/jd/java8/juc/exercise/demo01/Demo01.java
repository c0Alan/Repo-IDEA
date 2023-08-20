package com.jd.java8.juc.exercise.demo01;

/**
 * 三条线程轮流打印 ABCABCABC...
 * 
 * @author liuxilin
 * @date 2018/6/1 22:27
 */
public class Demo01 {
    public static void main(String[] args) {
        Subject subject = new Subject();
        ThreadA ta = new ThreadA(subject);
        ThreadB tb = new ThreadB(subject);
        ThreadC tc = new ThreadC(subject);

        ta.start();
        tb.start();
        tc.start();
    }
}
