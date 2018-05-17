package com.web.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 实现了HttpSessionBindingListener接口的 JavaBean对象可以感知自己被绑定到 Session中和从Session中删除的事件
 * 当对象被绑定到 HttpSession 对象中时，web 服务器调用该对象的  void valueBound(HttpSessionBindingEvent event) 方法
 * 当对象从 HttpSession 对象中解除绑定时，web 服务器调用该对象的 void valueUnbound(HttpSessionBindingEvent event)方法
 *
 * @author liuxilin
 * @date 2018/5/17 22:48
 */
public class JavaBeanDemo1 implements HttpSessionBindingListener {

    private String name;

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println(name + "被加到session中了");
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println(name + "被session踢出来了");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JavaBeanDemo1(String name) {
        this.name = name;
    }
}