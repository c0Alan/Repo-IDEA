package com.service.model;

/**
 * 类名称：Persion.java<br>
 * 类描述：<br>
 * 创建时间：2016年11月11日, 下午2:48:45
 * 
 * @version 1.0
 * @since JDK版本
 * @author flx
 */

public class Person {
    private String name;
	private int age;

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}