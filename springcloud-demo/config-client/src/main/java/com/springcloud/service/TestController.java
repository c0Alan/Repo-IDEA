package com.springcloud.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注入Git配置文件属性
 *
 * @author liuxl
 * @date 2018/4/15 10:47
 */
@RefreshScope
@RestController
class TestController {

    @Value("${info.profile}")
    private String info;

    @RequestMapping("/infoMsg")
    public String info() {
        return this.info;
    }

    public void setInfo(String from) {
        this.info = from;
    }

    public String getInfo() {
        return info;
    }

}