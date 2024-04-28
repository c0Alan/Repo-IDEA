package com.demo.java.structure.proxy.demo01;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * 动态代理类, 通过实现jdk api 实现动态代理
 * JDK内置的Proxy动态代理可以在运行时动态生成字节码，而没必要针对每个类编写代理类。
 * 中间主要使用到了一个接口InvocationHandler与Proxy.newProxyInstance静态方法，参数说明如下：
 * 使用内置的Proxy实现动态代理有一个问题：被代理的类必须实现接口，未实现接口则没办法完成动态代理。
 * 如果项目中有些类没有实现接口，则不应该为了实现动态代理而刻意去抽出一些没有实例意义的接口，
 * 通过cglib可以解决该问题。
 *
 * @author liuxilin
 * @date 2018/4/26 20:44
 */
public class DynamicProxy implements InvocationHandler {

    //被代理的对象
    Object targetObject;

    /**
     * 获得被代理后的对象
     *
     * @param object 被代理的对象
     * @return 代理后的对象
     */
    public Object getProxyObject(Object object) {
        this.targetObject = object;

        // loader:一个ClassLoader对象，定义了由哪个ClassLoader对象来生成代理对象进行加载
        // interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，
        // 如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，
        // 这样我就能调用这组接口中的方法了
        // h:一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，
        // 会关联到哪一个InvocationHandler对象上，间接通过invoke来执行
        return Proxy.newProxyInstance(
                targetObject.getClass().getClassLoader(), //类加载器
                targetObject.getClass().getInterfaces(),  //获得被代理对象的所有接口
                this);  //InvocationHandler对象

    }


    /**
     * 当用户调用对象中的每个方法时都通过下面的方法执行，方法必须在接口
     * proxy 被代理后的对象
     * method 将要被执行的方法信息（反射）
     * args 执行方法时需要的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //被织入的内容，开始时间
        long start = System.currentTimeMillis();
        lazy();

        //使用反射在目标对象上调用方法并传入参数
        Object result = method.invoke(targetObject, args);

        //被织入的内容，结束时间
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
        IMath math = (IMath) new DynamicProxy().getProxyObject(new Math2());
//        IMath math = (Math) new DynamicProxyFactory().getProxyObject(new Math()); // 报错, 这时应该使用Cglib的方式实现代理
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }

}