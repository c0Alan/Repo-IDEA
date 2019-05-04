package com.jdk.flow.trycatch;

public class FinallyDemo {
    public static int x = 1;

    public static void main(String[] args) {
        System.out.println (test()); // 1
        System.out.println (x); // 2
        System.out.println (get()); // 2
    }

    /**
     * 先返回 x 然后执行 ++x;
     * @return
     */
    public static int test() {
        try {
            return x;
        }finally {
            ++x;
        }
    }

    /**
     * Return 并不是让函数马上返回, 而是return 语句执行后, 将把返回结果放置进函数栈中,
     * 此时函数并不是马上返回, 它要执行finally 语句后才真正开始返回。
     * @return
     */
    public static int get(){
        try {
            return 1;
        }finally {
            return 2;
        }
    }
}