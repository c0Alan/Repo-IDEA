package com.demo.java.clazz;


import com.demo.java.entity.*;
import org.junit.Test;

import java.util.Scanner;

/**
 * 枚举类示例
 *
 * @author liuxilin
 * @date 2022/6/25 10:20
 */
public class EnumDemo {
    public static void main(String[] args) {
        EnumDemo demo = new EnumDemo();
        demo.test01();

    }

    /**
     * 用法一：常量 测试 Color 类型
     */
    @Test
    public void color(){
        System.out.println(Color.RED.equals("red")); // false
        System.out.println(Color.RED.equals("RED")); // false
        System.out.println(Color.RED.toString().equals("red")); // false
        System.out.println(Color.RED.toString().equals("RED")); // true

        // IllegalArgumentException: No enum constant com.jd.jdk.clazz.enumtype.Color.red
//        System.out.println(Enum.valueOf(Color.class, "red"));
        System.out.println(Enum.valueOf(Color.class, "RED")); // RED

        // IllegalArgumentException: No enum constant com.jd.jdk.clazz.enumtype.Color.abc
//        System.out.println(Enum.valueOf(Color.class, "abc"));
    }

    /**
     * 用法二：switch 测试 TrafficLight 类型
     */
    @Test
    public void trafficLight(){
        TrafficLight trafficLight = new TrafficLight();
        System.out.println(trafficLight.color); // RED
        trafficLight.change();
        System.out.println(trafficLight.color); // GREEN
    }

    /**
     * 用法三：向枚举中添加新方法 测试 Color2 类型
     */
    @Test
    public void color2(){
        System.out.println(Color2.RED); // RED
        System.out.println(Color2.RED.getName()); // 红色
        System.out.println(Color2.getName(3)); // 白色
    }

    /**
     * 用法四：覆盖枚举的方法 测试 Color3 类型
     */
    @Test
    public void color3(){
        System.out.println(Color3.RED); // 1_红色
    }

    /**
     * 用法六：使用接口组织枚举 测试 Food 类型
     */
    @Test
    public void food(){
        System.out.println(Food.Coffee.BLACK_COFFEE); //
        System.out.println(Food.Dessert.FRUIT); //
    }


    /**
     * 枚举类示例
     * 需再main方法中运行，@Test 方式不支持System.in
     */
//    @Test
    public void test01() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a size: (SMALL, MEDIUM, LARGE, EXTRA_LARGE) ");
        String input = in.next().toUpperCase();
        Size size = Enum.valueOf(Size.class, input);
        System.out.println("size=" + size);
        System.out.println("abbreviation=" + size.getAbbreviation());
        if (size == Size.EXTRA_LARGE) {
            System.out.println("Good job--you paid attention to the _.");
        }
    }
}


