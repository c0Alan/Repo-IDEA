package com.spring.demo02.helloworld;

public class HelloWorld {
	
	//�ֶ�
	private String user;
	
	public HelloWorld() {
		System.out.println("HelloWorld's constructor...");
	}
	
	//JavaBean ʹ�� setter �� getter ����������
	public void setUserName(String user) {
		System.out.println("setUserName:" + user);
		this.user = user;
	}
	
	public void hello(){
		System.out.println("Hello:" + user);
	}
	
	public void init(){
		System.out.println("init method...");
	}
	
	public void destroy(){
		System.out.println("destroy method...");
	}
	
}
