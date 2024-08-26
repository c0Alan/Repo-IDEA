package com.demo.springcloud.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@Slf4j
@WebListener
public class RequestListener implements ServletRequestListener {
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		log.info("初始化一个requestListener......");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		log.info("销毁一个requestListener......");
	}
}
