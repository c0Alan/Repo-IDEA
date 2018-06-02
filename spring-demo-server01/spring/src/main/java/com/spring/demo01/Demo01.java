package com.spring.demo01;

import com.spring.demo01.action.UserAction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo01 {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/demo01/beans-annotation.xml");
		UserAction userAction = ctx.getBean(UserAction.class);
		userAction.execute();
	}
	
}
