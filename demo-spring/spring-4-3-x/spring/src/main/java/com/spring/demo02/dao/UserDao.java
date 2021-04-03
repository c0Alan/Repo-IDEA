package com.spring.demo02.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	public void save(){
		System.out.println("UserDao's save...");
	}
	
}
