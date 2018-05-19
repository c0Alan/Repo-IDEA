package com.design.pattern.structure.proxy.demo02;

import com.design.pattern.structure.proxy.demo01.IMath;
import com.design.pattern.structure.proxy.demo01.Math2;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 封装动态代理类
 *
 * @author liuxilin
 * @date 2018/4/26 22:56
 */
public class SpringProxy<T> implements MethodInterceptor {

    /**
     * 获得代理后的对象
     */
    public T getProxyObject(Object target) {
        //代理工厂
        ProxyFactory proxy = new ProxyFactory();
        //添加被代理的对象
        proxy.setTarget(target);
        //添加环绕通知
        proxy.addAdvice(this);
        //获得代理后的对象
        return (T) proxy.getProxy();
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        //调用方法获得结果
        Object result = methodInvocation.proceed();
        after(result);
        return result;
    }

    public void before() {
        System.out.println("调用方法前");
    }

    public void after(Object result) {
        System.out.println("调用方法后" + result);
    }

    @Test
    public void test() {
        SpringProxy<IMath> proxy = new SpringProxy();
        IMath math = proxy.getProxyObject(new Math2());
        int n1 = 100, n2 = 5;
        math.add(n1, n2);
        math.sub(n1, n2);
        math.mut(n1, n2);
        math.div(n1, n2);
    }
}