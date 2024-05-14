package com.demo.springcloud.controller;

import com.demo.springcloud.remote.SchDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxilin
 * @since 2023-08-13
 */
@RestController
public class SchDemoController {
    @Autowired
    SchDemoService schDemoService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello(@RequestParam(value = "name") String name) {
        return schDemoService.hello(name);
    }
}
