package com.demo.springcloud.service.impl;


import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.demo.springcloud.config.AppFileConfig;
import com.demo.springcloud.entity.excel.XzqhExcelEntity;
import com.demo.springcloud.service.ExcelService;
import com.demo.springcloud.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("excelService")
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    FileService fileService;

    @Autowired
    AppFileConfig appFileConfig;

    @Override
    public String getXzqhDictData(){
        String path = fileService.getFilePath(appFileConfig.getXzqhExcelFilename());
        ExcelReader excelReader = ExcelUtil.getReader(path);
        List<List<Object>> list = excelReader.read(1);
        return list.toString();
    }
}
