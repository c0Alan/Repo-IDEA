package com.spring.demo02;

import com.spring.demo02.aop.ArithmeticCalculator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo02 {
	
	public static void main(String[] args) {
//		ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorImpl();
//		
//		arithmeticCalculator = 
//				new ArithmeticCalculatorLoggingProxy(arithmeticCalculator).getLoggingProxy();
//		
//		int result = arithmeticCalculator.add(11, 12);
//		System.out.println("result:" + result);
//		
//		result = arithmeticCalculator.div(21, 3);
//		System.out.println("result:" + result);
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/demo02/applicationContext-aop.xml");
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		System.out.println(arithmeticCalculator.getClass().getName());
		
		int result = arithmeticCalculator.add(11, 12);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(21, 3);
		System.out.println("result:" + result);
	}
	
}
