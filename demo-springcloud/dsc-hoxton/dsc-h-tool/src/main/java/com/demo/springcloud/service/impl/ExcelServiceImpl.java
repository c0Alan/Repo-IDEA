package com.demo.springcloud.service.impl;


import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.demo.springcloud.config.AppFileConfig;
import com.demo.springcloud.entity.Dict;
import com.demo.springcloud.entity.excel.XzqhExcelEntity;
import com.demo.springcloud.service.ExcelService;
import com.demo.springcloud.service.FileService;
import com.demo.springcloud.service.MybatisService;
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
    MybatisService mybatisService;

    @Override
    public List<Dict> getXzqhDictDataV2(){
        String path = fileService.getFilePath(appFileConfig.getXzqhExcelFilename());
        ExcelReader excelReader = ExcelUtil.getReader(path);
        List<Dict> xzqhList = excelReader.readAll(Dict.class);
        return xzqhList;
    }

    @Override
    public List<XzqhExcelEntity> getXzqhDictData(){
        String path = fileService.getFilePath(appFileConfig.getXzqhExcelFilename());
        ExcelReader excelReader = ExcelUtil.getReader(path);
        List<XzqhExcelEntity> xzqhList = excelReader.readAll(XzqhExcelEntity.class);
        return xzqhList;
    }

    /**
     * 从 行政区划数据.xlsx 导入数据
     * @return
     */
    @Override
    public String importXzqhDictData(){
        List<Dict> dictList = getXzqhDictDataV2();
        mybatisService.saveDictList(dictList);
        return dictList.toString();
    }


    /**
     * 提取 行政区划数据-old.xlsx 中的数据
     * @return
     */
    @Override
    public String saveXzqhDictData(){
        List<XzqhExcelEntity> list = getXzqhDictData();
        List<Dict> dictList = buildDictData(list);
        return dictList.toString();
    }

    /**
     * 提取 行政区划数据-old.xlsx 中的数据
     * @param list
     * @return
     */
    public List<Dict> buildDictData(List<XzqhExcelEntity> list) {
        int curId = mybatisService.getCurrentSysDictId() + 1;
        List<Dict> dictList = new ArrayList<>();
        for (int i=0; i<list.size(); i++) {
            XzqhExcelEntity xzqh = list.get(i);
            String code = xzqh.getCode();
            String name = xzqh.getName();
            int level = 3;
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
        mybatisService.saveDictList(dictList);
        return dictList;
    }
}
