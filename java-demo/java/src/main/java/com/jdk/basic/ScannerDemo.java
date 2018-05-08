package com.jdk.basic;

import org.junit.Test;

import java.util.Scanner;

/**
 * jdk 测试类入口
 *
 * @author liuxl
 * 2017-9-27 下午4:59:56
 */
public class ScannerDemo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据

        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }

    /**
     * junit 无法接受控制台输入, 下面程序无法输入
     */
    @Test
    public void test01() {
        Scanner scan = new Scanner(System.in);
        // 从键盘接收数据
        // next方式接收字符串
        System.out.println("next方式接收：");
        // 判断是否还有输入
        if (scan.hasNext()) {
            String str1 = scan.next();
            System.out.println("输入的数据为：" + str1);
        }
        scan.close();
    }

}
