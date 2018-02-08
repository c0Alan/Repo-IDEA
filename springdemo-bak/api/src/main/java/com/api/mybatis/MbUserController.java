package com.api.mybatis;

import com.service.mybatis.UserService;
import com.service.mybatis.impl.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class MbUserController {

    @Autowired
    TUserService tUserService;

    @RequestMapping(value = "/getTableData")
    public Object findAllUser(@RequestParam("pageNum") Integer pageNum,
                              @RequestParam("pageSize") Integer pageSize) {
        return tUserService.getAllUser(pageNum, pageSize);
    }
}
