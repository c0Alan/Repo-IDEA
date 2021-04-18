package com.demo.springboot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MvcController {

    @RequestMapping("/sayHi/{name}")
    public String sayHi(@PathVariable("name") String name) {
        return "hi! " + name;
    }

    @RequestMapping("/sayHello")
    public String sayHello(@RequestParam String name) {
        return "你好! " + name;
    }

    @RequestMapping(value = "/sayGood", method = {RequestMethod.POST})
    public String sayGood(@RequestBody(required = false) String name) {
        return "find! " + name;
    }


}
