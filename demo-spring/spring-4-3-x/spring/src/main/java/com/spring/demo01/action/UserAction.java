package com.spring.demo01.action;

import com.spring.demo01.service.UserService;
import com.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction {

	@Autowired
	private UserService userService;

	public void execute(){
		System.out.println("接受请求");
		User user = new User();
		userService.addNew(user);
	}
	
}
