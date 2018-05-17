package com.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * MyServletContextListener类实现了ServletContextListener接口，
 * 因此可以对ServletContext对象的创建和销毁这两个动作进行监听。
 *
 * @author liuxilin
 * @date 2018/5/17 22:35
 */
public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContext对象创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContext对象销毁");
    }
}