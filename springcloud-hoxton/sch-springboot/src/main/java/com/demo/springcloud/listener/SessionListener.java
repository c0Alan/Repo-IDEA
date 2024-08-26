package com.demo.springcloud.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * session监听器
 * 参考: https://blog.csdn.net/qgnczmnmn/article/details/106622109
 *
 * @author liuxl
 * @date 2024/8/25
 */
@Slf4j
@WebListener
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		log.info("初始化一个sessionListener......, {}", se.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		log.info("销毁一个sessionListener......");
	}
}
