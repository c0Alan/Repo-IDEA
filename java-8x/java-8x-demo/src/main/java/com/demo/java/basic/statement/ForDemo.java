package com.demo.java.basic.statement;

import java.util.Scanner;

/**
 * This program demonstrates a <code>for</code> loop.
 *
 * @author Cay Horstmann
 * @version 1.20 2004-02-10
 */
public class ForDemo {
    public static void main(String[] args) {
        demo01();
    }

    /**
     * 计算抽奖中奖的概率,
     */
    public static void demo01() {
        Scanner in = new Scanner(System.in);

        System.out.print("How many numbers do you need to draw? ");
        int k = in.nextInt();

        System.out.print("What is the highest number you can draw? ");
        int n = in.nextInt();

        /*
         * compute binomial coefficient n*(n-1)*(n-2)*...*(n-k+1)/(1*2*3*...*k)
         */

        int lotteryOdds = 1;
        for (int i = 1; i <= k; i++) {
            lotteryOdds = lotteryOdds * (n - i + 1) / i;
        }

        System.out.println("Your odds are 1 in " + lotteryOdds + ". Good luck!");
    }
}