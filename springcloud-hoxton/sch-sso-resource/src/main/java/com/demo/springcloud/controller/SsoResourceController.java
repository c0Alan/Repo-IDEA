package com.demo.springcloud.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sso/resource")
public class SsoResourceController {
//    @Secured({"ROLE_1","ROLE_2"})
    @Secured({"ROLE_2"})
    @GetMapping("/info")
    public String info() {
        return "Resource Controller ...";
    }
}