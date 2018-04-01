package com.hibernate.controller;

import com.hibernate.dao.UserDao;
import com.hibernate.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    UserDao userDao;

    @RequestMapping("first")
    public String first(Model model) {
        TUser user =  userDao.findByCLoginid("meichangsu");
        model.addAttribute("userName", user.getcName());
        return "first";
    }

}