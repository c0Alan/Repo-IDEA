package com.demo.springcloud.serviceribbon.web;

import com.demo.springcloud.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Email miles02@163.com
 *
 * @author fangzhipeng
 * create 2018-07-09
 **/
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name);
    }

    @GetMapping(value = "/slowHi")
    public String showHi(@RequestParam(value = "name") String name,
                         @RequestParam(value = "delayTime") Integer delayTime) {

        return helloService.slowHi(name, delayTime);
    }

    @GetMapping(value = "/notExistHi")
    public String notExistHi(@RequestParam String name) {
        return helloService.notExistHi(name);
    }
}
