package com.spring.demo02.action;

import com.spring.demo02.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserAction {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void execute() {
        System.out.println("execute...");
        userService.addNew();
    }

}
