package com.demo.springcloud.controller;

import com.demo.springcloud.entity.User;
import com.demo.springcloud.remote.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @ApiOperation("新增用户")
    @PostMapping("/saveUser")
    public int saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @ApiOperation("新增用户-测试swagger文档")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user",value = "json对象", required = true, paramType = "body")
    })
    @PostMapping("/saveUser2")
    public int saveUser2(@RequestBody User user) {
        return userService.saveUser(user);
    }

    /**
     * 根据id查询用户
     *
     * @param id
     * @return
     */
    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    /**
     * 根据年龄查询用户
     *
     * @param age
     * @return
     */
    @GetMapping("/listUserByAge")
    public List<User> listUserByAge(@RequestParam int age) {
        return userService.listUserByAge(age);
    }

    /**
     *
     * @param userList
     * @return
     */
    @ApiOperation(value="批量新增用户", notes = "批量新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userList", value = "json对象", required = true, paramType = "body")
    })
    @PostMapping("/saveUserList")
    public int saveDictList(@RequestBody List<User> userList){
        return userService.saveUserList(userList);
    }
}
