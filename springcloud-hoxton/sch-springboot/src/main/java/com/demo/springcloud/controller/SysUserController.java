package com.demo.springcloud.controller;

import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.response.ResponseResult;
import com.demo.springcloud.service.impl.SysUserServiceImpl;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * sysUser 操作接口
 *
 * @author liuxl
 * @date 2024/9/7
 */
@Api(tags = "sysUser操作接口")
@RestController
@Slf4j
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private SysUserServiceImpl sysUserService;

    @GetMapping("/getAllUser")
    public ResponseResult getAllUser() {
        return ResponseResult.success(sysUserService.list());
    }

    @PostMapping("/saveUser")
    public ResponseResult saveUser(@RequestBody SysUser sysUser) {

        return ResponseResult.success(sysUserService.saveEncrypt(sysUser));
    }

}
