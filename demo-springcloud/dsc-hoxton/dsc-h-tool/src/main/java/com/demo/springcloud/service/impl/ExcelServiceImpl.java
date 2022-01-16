package com.demo.springcloud.service.impl;


import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.demo.springcloud.config.AppFileConfig;
import com.demo.springcloud.entity.Dict;
import com.demo.springcloud.entity.excel.XzqhExcelEntity;
import com.demo.springcloud.service.ExcelService;
import com.demo.springcloud.service.FileService;
import com.demo.springcloud.service.MybatisDictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service("excelService")
public class ExcelServiceImpl implements ExcelService {
    @Autowired
    FileService fileService;

    @Autowired
    AppFileConfig appFileConfig;

    @Autowired
    MybatisDictService mybatisDictService;

    @Override
    public List<XzqhExcelEntity> getXzqhDictData(){
        String path = fileService.getFilePath(appFileConfig.getXzqhExcelFilename());
        ExcelReader excelReader = ExcelUtil.getReader(path);
        List<XzqhExcelEntity> xzqhList = excelReader.readAll(XzqhExcelEntity.class);
        return xzqhList;
    }

    @Override
    public String saveXzqhDictData(){
        List<XzqhExcelEntity> list = getXzqhDictData();
        List<Dict> dictList = buildDictData(list);
        return dictList.toString();
    }

    public List<Dict> buildDictData(List<XzqhExcelEntity> list) {
        int curId = mybatisDictService.getCurrentSysDictId() + 1;
        List<Dict> dictList = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            XzqhExcelEntity xzqh = list.get(i);
            String code = xzqh.getCode();
            String name = xzqh.getName();
            byte level = 3;
            Dict dict = new Dict();
            dict.setId(curId++);
            if (StrUtil.endWith(code, "0000")) {
                level = 1;
            } else if (StrUtil.endWith(code, "00")) {
                level = 2;
            }
            dict.setDictLevel(level);
            dict.setDictTypeCode("xzqh");
            dict.setDictTypeName("行政区划");
            dict.setDictDataCode(code);
            dict.setDictDataName(name);
            dictList.add(dict);
        }
        mybatisDictService.saveDictList(dictList);
        return dictList;
    }
}
