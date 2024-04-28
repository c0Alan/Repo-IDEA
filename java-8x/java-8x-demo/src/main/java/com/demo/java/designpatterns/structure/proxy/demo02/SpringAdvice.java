package com.demo.java.designpatterns.structure.proxy.demo02;

import com.demo.java.designpatterns.structure.proxy.demo01.IMath;
import com.demo.java.designpatterns.structure.proxy.demo01.Math2;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 如果要代理不同的对象需要反复创建ProxyFactory对象，代码会冗余。
 *
 * 切面（ASPECT）：横切关注点被模块化的特殊对象。即，它是一个类。
 * 通知（Advice）：切面必须要完成的工作。即，它是类中的一个方法。
 * 目标（Target）：被通知对象。
 * 代理（Proxy）：向目标对象应用通知之后创建的对象。
 * 切入点（PointCut）：切面通知执行的“地点”的定义。
 * 连接点（JointPoint）：与切入点匹配的执行点。
 * 
 * @author liuxilin
 * @date 2018/4/26 22:40
 */
public class SpringAdvice {

    @Test
    public void test() {
        //实例化Spring代理工厂
        ProxyFactory factory = new ProxyFactory();
        //设置被代理的对象
        factory.setTarget(new Math2());
        //添加通知，横切逻辑
        factory.addAdvice(new BeforeAdvice());
        factory.addAdvice(new AfterAdvice());
        factory.addAdvice(new SurroundAdvice());
        //从代理工厂中获得代理对象
        IMath math = (IMath) factory.getProxy();
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }

    @Test
    public void test2() {
        //从代理工厂中获得代理对象
        IMath math = (IMath) DynamicProxyFactory.getProxy(new Math2());
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }
}