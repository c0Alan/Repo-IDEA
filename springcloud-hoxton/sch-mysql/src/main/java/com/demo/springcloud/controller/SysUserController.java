package com.demo.springcloud.controller;


import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.sse.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuxilin
 * @since 2023-08-15
 */
@RestController
@RequestMapping("/tUser")
public class SysUserController {

    @Autowired
    SysUserService tUserService;

    @GetMapping("/list")
    public List<SysUser> listUsers(){
        return tUserService.list();
    }

}
