package com.demo.java.structure.proxy.demo01;

import org.junit.Test;

import java.util.Random;


/**
 * 静态代理类
 * 与被代理的类实现同一个接口, 并持有被代理的类
 * 5.1、解决了“开闭原则（OCP）”的问题，因为并没有修改Math类，而扩展出了MathProxy类。
 * 5.2、解决了“依赖倒转（DIP）”的问题，通过引入接口。
 * 5.3、解决了“单一职责（SRP）”的问题，Math类不再需要去计算耗时与延时操作，但从某些方面讲MathProxy还是存在该问题。
 * 未解决：
 * 5.4、如果项目中有多个类，则需要编写多个代理类，工作量大，不好修改，不好维护，不能应对变化。
 * 如果要解决上面的问题，可以使用动态代理。
 *
 * @author liuxilin
 * @date 2018/4/26 20:41
 */
public class MathProxy implements IMath {

    //被代理的对象
    IMath math = new Math2();

    //加
    public int add(int n1, int n2) {
        //开始时间
        long start = System.currentTimeMillis();
        lazy();
        int result = math.add(n1, n2);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }

    //减法
    public int sub(int n1, int n2) {
        //开始时间
        long start = System.currentTimeMillis();
        lazy();
        int result = math.sub(n1, n2);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }

    //乘
    public int mut(int n1, int n2) {
        //开始时间
        long start = System.currentTimeMillis();
        lazy();
        int result = math.mut(n1, n2);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }

    //除
    public int div(int n1, int n2) {
        //开始时间
        long start = System.currentTimeMillis();
        lazy();
        int result = math.div(n1, n2);
        Long span = System.currentTimeMillis() - start;
        System.out.println("共用时：" + span);
        return result;
    }

    //模拟延时
    public void lazy() {
        try {
            int n = (int) new Random().nextInt(500);
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        MathProxy mathProxy = new MathProxy();
        int n1 = 100, n2 = 5;
        mathProxy.add(n1, n2);
        mathProxy.sub(n1, n2);
        mathProxy.mut(n1, n2);
        mathProxy.div(n1, n2);
    }
}