package com.hibernate.service.impl;

import com.hibernate.dao.UserDao;
import com.hibernate.model.TUser;
import com.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
    private UserDao userdao;
	
	@Override
	public TUser findByCLoginid(String username) {
		return userdao.findByCLoginid(username);
	}

	@Override
	public void addUser(TUser user) {
		userdao.save(user);
	}

}