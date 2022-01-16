package com.demo.springcloud.controller;

import com.demo.springcloud.service.ExcelService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Excel 文件操作")
@RestController
@Slf4j
@RequestMapping("/excelfile")
public class ExcelFileController {
    @Autowired
    ExcelService excelService;

    @GetMapping("/getXzqhDictData")
    public String getXzqhDictData(){
        return excelService.getXzqhDictData().toString();
    }

    @GetMapping("/saveXzqhDictData")
    public String saveXzqhDictData(){
        String retult = excelService.saveXzqhDictData();
        return retult;
    }
}
