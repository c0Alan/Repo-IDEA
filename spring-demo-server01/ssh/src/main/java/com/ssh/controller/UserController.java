package com.ssh.controller;

import com.ssh.entity.TSysRole;
import com.ssh.entity.TUser;
import com.ssh.service.SysRoleService;
import com.ssh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("/login")
    public String login(TUser user, HttpServletRequest request) {
        TUser u = userService.getUserById(2);
        List<Map<String, Object>> resultMap = userService.getNameAndAddressByState(1);
        TSysRole role = sysRoleService.getRole(2);

        return "redirect:/success.jsp";
    }
}