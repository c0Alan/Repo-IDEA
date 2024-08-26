package com.demo.springcloud.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("初始化一个servletContext......");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
		log.info("销毁一个servletContext......");
    }
}
