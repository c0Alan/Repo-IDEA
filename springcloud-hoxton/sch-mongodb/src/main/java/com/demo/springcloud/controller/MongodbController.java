package com.demo.springcloud.controller;

import com.demo.springcloud.document.User;
import com.demo.springcloud.response.ResponseResult;
import com.demo.springcloud.service.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "mongodb接口示例")
@RestController
@Slf4j
@RequestMapping("/mongodb")
public class MongodbController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") String id) {
        userService.deleteUserById(id);
    }

    @GetMapping("/getUsersByName")
    public List<User> getUsersByName(@RequestParam String name) {
        return userService.getUserByCondition(name);
    }

    @GetMapping("/getUsersByCondition")
    public List<User> getUsersByCondition(@RequestParam int pageNum, @RequestParam int pageSize) {
        return userService.getUserByCondition(pageNum, pageSize);
    }

    @PostMapping("/updateUser")
    public ResponseResult updateUser(@RequestBody User user) {
        userService.update(user);
        return ResponseResult.success();
    }


}
