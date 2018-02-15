package com.api.hibernate;

import com.hibernate.model.TUser;
import com.hibernate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

@RestController
@RequestMapping("/hibernate")
public class UserController {

    @Autowired
    private UserService userService;
	
	/**
	 * 测试地址  http://localhost:8080/getUser?name=zhao
	 * @param loginId
	 * @return
	 */
	@RequestMapping("/getUser")
	@ResponseBody
	public String user(String loginId) {
		TUser user = userService.findByCLoginid(loginId);
		return JSON.toJSONString(user);
	}
	
	/**
	 * 测试地址 http://localhost:8080/addUser?userName=zhao
	 * @param user
	 * @return
	 */
	@RequestMapping("/addUser")
	@ResponseBody
	public String adduser(TUser user) {
		userService.addUser(user);
		return "add success!";
	}
}