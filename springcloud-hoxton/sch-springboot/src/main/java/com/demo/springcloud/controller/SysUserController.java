package com.demo.springcloud.controller;

import cn.hutool.core.util.StrUtil;
import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.response.ResponseResult;
import com.demo.springcloud.service.SysUserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    private SysUserService sysUserService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @GetMapping("/getAllUser")
    public ResponseResult getAllUser() {
        return ResponseResult.success(sysUserService.list());
    }

    @PostMapping("/saveUser")
    public ResponseResult saveUser(@RequestBody SysUser sysUser) {
        if (StrUtil.isNotBlank(sysUser.getPassword())){
            sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        }

        return ResponseResult.success(sysUserService.save(sysUser));
    }

}
