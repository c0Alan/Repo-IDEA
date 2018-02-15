package com.hibernate.service;

import com.hibernate.model.TUser;

public interface UserService {
    TUser findByCLoginid(String username);
	
	void addUser(TUser user);
}
