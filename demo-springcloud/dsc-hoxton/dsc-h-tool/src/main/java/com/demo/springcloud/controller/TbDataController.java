package com.demo.springcloud.controller;

import com.demo.springcloud.remote.TbDataService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "表数据导入")
@RestController
@Slf4j
@RequestMapping("/tbData")
public class TbDataController {
    @Autowired
    TbDataService tbDataService;

    /**
     * 从 表数据.xlsx 导入表数据
     *
     * @return
     */
    @GetMapping("/saveTbData")
    public String saveTbData() {
        String result = tbDataService.saveTbData();
        return result;
    }
}
