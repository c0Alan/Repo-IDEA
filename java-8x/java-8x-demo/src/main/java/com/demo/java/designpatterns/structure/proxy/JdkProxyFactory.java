package com.demo.java.designpatterns.structure.proxy;

import com.demo.java.designpatterns.structure.proxy.demo02.TimeSpanAdvice;
import org.springframework.aop.framework.ProxyFactory;

/**
 * 封装动态代理类
 *
 * @author liuxilin
 * @date 2018/4/26 22:47
 */
public abstract class JdkProxyFactory {
    /**
     * 获得代理对象
     *
     * @param object 被代理的对象
     * @return 代理对象
     */
    public static Object getProxy(Object object) {
        //实例化Spring代理工厂
        ProxyFactory factory = new ProxyFactory();
        //设置被代理的对象
        factory.setTarget(object);
        //添加通知，横切逻辑
        factory.addAdvice(new TimeSpanAdvice());
        return factory.getProxy();
    }


}