package com.demo.java.jdk.clazz.enumtype;

import org.junit.Test;

/**
 * 枚举测试类
 *
 * @author liuxl
 * @date 2018/4/7 9:33
 */
public class EnumTest {

    /**
     * 测试 Color 类型
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
     * 测试 Color2 类型
     */
    @Test
    public void color2(){
        System.out.println(Color2.RED); // RED
        System.out.println(Color2.RED.getName()); // 红色
        System.out.println(Color2.getName(3)); // 白色
    }

    /**
     * 测试 Color3 类型
     */
    @Test
    public void color3(){
        System.out.println(Color3.RED); // 1_红色
    }

    /**
     * 测试 Food 类型
     */
    @Test
    public void food(){
        System.out.println(Food.Coffee.BLACK_COFFEE); //
        System.out.println(Food.Dessert.FRUIT); //
    }

    /**
     * 测试 TrafficLight 类型
     */
    @Test
    public void trafficLight(){
        TrafficLight trafficLight = new TrafficLight();
        System.out.println(trafficLight.color); // RED
        trafficLight.change();
        System.out.println(trafficLight.color); // GREEN
    }

}
