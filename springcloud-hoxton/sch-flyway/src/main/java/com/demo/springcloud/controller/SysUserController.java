package com.demo.springcloud.controller;


import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.sse.SysUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author liuxl
 * @since 2024-05-14
 */
@Api(tags = "用户接口")
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/list")
    public List<SysUser> list()
    {
        return sysUserService.list();
    }

}
