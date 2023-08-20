package com.jd.java8.jvm.layout;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法区和运行时常量池内存溢出
 * 运行时产生大量的类去填满方法区
 * 通过 CGLib 直接操作字节码生成大量的动态类
 * VM Args： -XX:PermSize=10M -XX:MaxPermSize=10M // OutOfMemoryError: PermGen space
 * VM Args： -XX:MetaspaceSize=10M -XX:MaxMetaspaceSize=10M // OutOfMemoryError: Metaspace
 *
 * @author liuxilin
 * @date 2018/5/26 15:04
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
