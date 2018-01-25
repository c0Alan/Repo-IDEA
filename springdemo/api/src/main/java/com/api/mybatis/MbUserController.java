package com.api.mybatis;

import com.service.mybatis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MbUserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getTableData")
    public Object findAllUser(@RequestParam("pageNum") Integer pageNum,
                              @RequestParam("pageSize") Integer pageSize) {
        return userService.findAllUser(pageNum, pageSize);
    }
}
