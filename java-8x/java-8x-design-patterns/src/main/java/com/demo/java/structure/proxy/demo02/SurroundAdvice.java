package com.demo.java.structure.proxy.demo02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 环绕通知
 * 方法拦截器
 *
 */
public class SurroundAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation i) throws Throwable {
        //前置横切逻辑
        System.out.println("方法 " + i.getMethod() + "\n被调用在对象 " + i.getThis() + " 上\n参数 " + i.getArguments());
        //方法调用
        Object ret = i.proceed();
        //后置横切逻辑
        System.out.println("返回值："+ ret);
        return ret;
    }
}