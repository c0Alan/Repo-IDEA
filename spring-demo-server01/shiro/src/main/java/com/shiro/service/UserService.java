package com.shiro.service;


import com.shiro.model.TUser;

public interface UserService {
    TUser findByCLoginid(String username);
	
	void addUser(TUser user);
}
