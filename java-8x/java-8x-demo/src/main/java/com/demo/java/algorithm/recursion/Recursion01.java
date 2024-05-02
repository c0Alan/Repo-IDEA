package com.demo.java.algorithm.recursion;

/**
 * 数学归纳法
 * 
 * @author liuxilin
 * @date 2018/5/29 22:26
 */
public class Recursion01 {
    public static void main(String[] args) {
        Recursion01 r = new Recursion01();
        System.out.println(r.factorial(10));
        int[] c = new int[4];
        r.coding(c, 3);
        r.hanio(5, 'x', 'y', 'z');
    }

    /**
     * 斐波那契
     * 计算一个整数n 的阶乘
     *
     * @param n
     * @return
     */
    public long factorial(int n) {
        long result = 0;
        if (n == 0) result = 1;
        else result = n * factorial(n - 1);
        return result;
    }

    /**
     * 计算以x 为底的n 次幂，其中n 为非负整数。
     * 计算整数次幂可以简单的使用一个循环迭代n 次，每让x 乘以自身即可。
     * 但是这样算法的时间复杂度为Θ(n)，效率较低。
     * 下面我们设计一个新的算法，可以使得时间复杂度为Θ(log n)。
     *
     * @param x
     * @param n
     * @return
     */
    public int power(int x, int n) { // 1.
        int y;
        if (n == 0) // 3. 递归终止条件
            y = 1;
        else {
            y = power(x, n / 2); // 6. 递归调用
            y = y * y;
            if (n % 2 == 1) y = y * x;
        }
        return y;
    }

    /**
     * 编写一个算法输出n 个布尔量的所有可能组合。
     * 每个布尔量有真和假两种取值，分别对应1，0。对于n个布尔量有2n种组合，每一种均为n位。
     * @param b
     * @param n
     */
    public void coding(int[] b, int n) {
        if (n == 0) {
            b[n] = 0;
            outBn(b);
            b[n] = 1;
            outBn(b);
        } else {
            b[n] = 0;
            coding(b, n - 1);
            b[n] = 1;
            coding(b, n - 1);
        }
    }

    private void outBn(int[] b) {
        for (int i = 0; i < b.length; i++) System.out.print(b[i]);
        System.out.println();
    }

    /**
     * 求解n 阶汉诺塔问题
     * @param n
     * @param x
     * @param y
     * @param z
     */
    public void hanio(int n, char x, char y, char z) {
        if (n == 1) move(x, n, z);
        else {
            hanio(n - 1, x, z, y);
            move(x, n, z);
            hanio(n - 1, y, x, z);
        }
    }

    private void move(char x, int n, char y) {
        System.out.print("Move " + n);
        System.out.print(" from " + x);
        System.out.println(" to " + y);
    }

}