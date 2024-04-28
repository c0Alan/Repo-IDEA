package com.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * 监听ServletRequest域对象的创建和销毁
 * MyServletRequestListener类实现了ServletRequestListener接口，
 * 因此可以对ServletRequest对象的创建和销毁这两个动作进行监听。
 * <p>
 * ServletRequest域对象创建和销毁时机：
 * 　　　　创建：用户每一次访问都会创建request对象
 * 　　　　销毁：当前访问结束，request对象就会销毁
 *
 * @author liuxilin
 * @date 2018/5/17 22:40
 */
public class MyServletRequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println(sre.getServletRequest() + "销毁了！！");

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println(sre.getServletRequest() + "创建了！！");
    }
}