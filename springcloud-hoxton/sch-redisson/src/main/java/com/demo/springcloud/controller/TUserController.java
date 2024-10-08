package com.demo.springcloud.controller;


import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.sse.TUserService;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  前端控制器
 *
 * @author liuxilin
 * @since 2023-08-15
 */
@RestController
@RequestMapping("/tUser")
public class TUserController {

    @Autowired
    TUserService tUserService;

    @Autowired
    private RedissonClient redissonClient;

    @GetMapping("/list")
    public List<SysUser> listUsers(){
        return tUserService.list();
    }

    @GetMapping("/add")
    public String addUser(){
        SysUser sysUser = new SysUser();
        sysUser.setUsername("test");
        tUserService.save(sysUser);

        return "success";
    }

    @GetMapping("/getById/{id}")
    public SysUser getById(@PathVariable Integer id){
        return tUserService.getById(id);
    }


}
