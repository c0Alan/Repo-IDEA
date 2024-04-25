package com.demo.java.java8.base.stackTrace;

import java.util.*;

/**
 * StackTrace 示例
 *
 * @author liuxilin
 * @date 2022/6/26 16:20
 */
public class StackTraceTest {
    /**
     * Computes the factorial of a number
     *
     * @param n a non-negative integer
     * @return n! = 1 * 2 * . . . * n
     */
    public static int factorial(int n) {
        System.out.println("factorial(" + n + "):");
        Throwable t = new Throwable();
        StackTraceElement[] frames = t.getStackTrace();
        for (StackTraceElement f : frames) {
           System.out.println(f);
        }
        int r;
        if (n <= 1) {
           r = 1;
        } else {
           r = n * factorial(n - 1);
        }
        System.out.println("return " + r);
        return r;
    }

   /**
    * 打印斐波那契算法堆栈信息
    * @param args
    */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = in.nextInt();
        factorial(n);
    }
}
