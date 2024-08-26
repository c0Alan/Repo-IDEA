package com.demo.springcloud.controller;

import com.demo.springcloud.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "测试过滤器、拦截器")
@Slf4j
@RestController
@RequestMapping("/demo2")
public class Demo2Controller {

    @ApiOperation(value = "GetMapping, PathVariable方式")
    @GetMapping("/users/{id}")
    public SysUser getUser(@PathVariable Integer id) {
        SysUser user = new SysUser();
        user.setId(id);
        return user;
    }

    @ApiOperation(value = "GetMapping, RequestParam方式")
    @GetMapping("/users")
    public SysUser getUser2(@RequestParam Integer id) {
        SysUser user = new SysUser();
        user.setId(id);
        return user;
    }

    @ApiOperation(value = "PostMapping, RequestBody方式")
    @PostMapping("/searchUsers")
    public List<SysUser> searchUsers(@RequestBody SysUser userQo) {
        List<SysUser> users = new ArrayList<>();
        users.add(new SysUser(1, "user1", "123456"));
        users.add(new SysUser(2, "user2", "123456"));
        return users;
    }


    @ApiOperation(value = "createUser, PostMapping, RequestBody方式", notes = "返回ResponseEntity<SysUser>")
    @PostMapping("/users")
    public ResponseEntity<SysUser> createUser(@RequestBody SysUser user) {
        return ResponseEntity.ok(user);
    }

    @ApiOperation(value = "getUser, PostMapping, RequestBody方式", notes = "返回SysUser")
    @PostMapping("/getUser")
    public SysUser getUser(@RequestBody SysUser user) {
        return user;
    }

    @ApiOperation(value = "PutMapping, PathVariable+RequestBody方式")
    @PutMapping("/users/{id}")
    public ResponseEntity<SysUser> updateUser(@PathVariable Integer id, @RequestBody SysUser updatedUser) {
        updatedUser.setId(id);
        return ResponseEntity.ok(updatedUser);
    }

}
