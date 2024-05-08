package com.demo.springcloud.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('ROLE_NORMAL')")
    public String list() {
        return "list";
    }
}