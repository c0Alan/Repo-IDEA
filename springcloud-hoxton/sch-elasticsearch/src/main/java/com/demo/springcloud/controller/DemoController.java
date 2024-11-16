package com.demo.springcloud.controller;

import com.demo.springcloud.utils.NetUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "demo接口示例")
@RestController
@Slf4j
@RequestMapping("/demo")
public class DemoController {

    /***************************************** hello *****************************************/
    @ApiOperation(value = "hello方法", notes = "hello方法")
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        String serverIp = NetUtil.getServerIpList();
        log.info("sch-elasticsearch serverIp: " + serverIp + ",invoked hello，name = " + name);
        return " sch-elasticsearch serverIp: " + serverIp + ",hello " + name;
    }

}
