package com.demo.api.controller;

import com.demo.service.UserRedisService;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserRedisService userRedisService;
    /**
     * @Title: UserController
     * @Description: 初始化redis数据
     * @return
     * @throws
     */
    @RequestMapping("/initRedisdata")
    @ResponseBody
    public String initRedisData(){
        userRedisService.redisInitData();
        return "success";
    }
    @RequestMapping("/getUserRedisByLoginName/{loginName}")
    @ResponseBody
    public Map<String,Object> getUserRedisByLoginName(@PathVariable String loginName){
        Map<String,Object> result = new HashMap<String, Object>();
        User user = userRedisService.getUserRedis(loginName);
        Assert.notNull(user);
        result.put("name", user.getName());
        result.put("loginName", user.getLoginName());
        result.put("departmentName",user.getDepartment().getName());
        result.put("roleName", user.getRoleList().get(0).getName());
        return result;
    }
}
