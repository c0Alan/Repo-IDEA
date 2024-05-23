package com.demo.springcloud.controller;

import com.demo.springcloud.service.BusinessService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 交易接口，seata 测试入口
 * @author liuxl
 * @date 2024/5/14
 */
@Api(tags = "交易接口")
@RestController
@Slf4j
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    BusinessService businessService;

    @RequestMapping("/purchase")
    public String purchase(String userId, String commodityCode, int orderCount)
    {
        businessService.purchase(userId, commodityCode, orderCount);
        return "success";
    }
}


