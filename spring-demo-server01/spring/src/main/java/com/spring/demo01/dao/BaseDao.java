package com.spring.demo01.dao;

public class BaseDao<T> {

	public void save(T entity){
		System.out.println("Save:" + entity);
	}
	
}
