package com.api.mybatis;

import com.service.mybatis.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController1 {
    @Autowired
    TestService testService;

    @RequestMapping("/test")
    public String test(){
        return testService.test();
    }
}
