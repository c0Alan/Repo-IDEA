package com.demo.springcloud.controller;

import com.demo.springcloud.service.DictDataService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "字典操作api")
@RestController
@Slf4j
@RequestMapping("/dict")
public class DictController {
    @Autowired
    DictDataService dictDataService;

    /**
     * 重置字典数据
     *
     * @return
     */
    @GetMapping("/resetDictData")
    public int resetDictData() {
        return dictDataService.resetDictData();
    }
}
