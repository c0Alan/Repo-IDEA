package com.demo.springcloud.remote;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.demo.springcloud.config.AppFileConfig;
import com.demo.springcloud.entity.Dict;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service("dictDataService")
public class DictDataService {
    @Autowired
    FileService fileService;

    @Autowired
    AppFileConfig appFileConfig;

    @Autowired
    MybatisService mybatisService;

    /**
     * 重置字典数据
     * @return
     */
    public int resetDictData() {
        List<Dict> dictList = new ArrayList<>();

        String path = fileService.getFilePath(appFileConfig.getDictExcelFilename());
        ExcelReader excelReader = ExcelUtil.getReader(path);
        List<Sheet> sheets = excelReader.getSheets();
        for (int i = 0; i < sheets.size(); i++) {
            Sheet sheet = sheets.get(i);
            String sheetName = sheet.getSheetName();
            ExcelReader sheetReader = excelReader.setSheet(sheet);
            List<Map<String, Object>> sheetData = sheetReader.readAll();
            if (StrUtil.equals("xzqh", sheetName)){
                buildXzqhDictData(sheetData, dictList);
                continue;
            }
            buildDictData(sheetData, dictList);
        }
        excelReader.close();

        int success = 0;
        // 每次新增1000条记录
        for (int i=0; i<dictList.size(); i+=1000) {
            int start = i;
            int end = i+1000;
            List<Dict> subList = CollectionUtil.sub(dictList, start, end);
            mybatisService.saveDictList(subList);
            success += subList.size();
        }
        return success;
    }

    /**
     * 构建行政区划字典数据列表
     * @param sheetData
     * @param dictList
     * @return
     */
    public List<Dict> buildXzqhDictData(List<Map<String, Object>> sheetData, List<Dict> dictList) {
        Map<String, Dict> cache = new HashMap();
        Map typeData = sheetData.get(0);
        Dict dictType = buildDictType(typeData);
        Dict parentDict = dictType;
        dictList.add(dictType);
        for (int i=1; i<sheetData.size(); i++) {
            Map dictData = sheetData.get(i);
            String dictCode = (String) dictData.get("code");
            dictCode = dictCode.replaceAll("0+$", "");
            if(dictCode.length() == 4){
                String parentDictCode = dictCode.substring(0,2);
                parentDict = cache.get(parentDictCode);
            }
            if(dictCode.length() == 6){
                String parentDictCode = dictCode.substring(0,4);
                parentDict = cache.get(parentDictCode);
            }
            if(dictCode.length() == 9){
                String parentDictCode = dictCode.substring(0,6);
                parentDict = cache.get(parentDictCode);
            }
            if(dictCode.length() == 12){
                String parentDictCode = dictCode.substring(0,9);
                parentDict = cache.get(parentDictCode);
            }
            if (ObjectUtil.isNull(parentDict)){
                continue;
            }
            Dict dict = buildDict(dictData, parentDict);
            dictList.add(dict);
            cache.put(dictCode, dict);
        }

        return dictList;
    }

    /**
     * 构建字典数据列表
     * @param sheetData
     * @param dictList
     * @return
     */
    public List<Dict> buildDictData(List<Map<String, Object>> sheetData, List<Dict> dictList) {
        Map typeData = sheetData.get(0);
        Dict dictType = buildDictType(typeData);
        dictList.add(dictType);
        for (int i=1; i<sheetData.size(); i++) {
            Map dictData = sheetData.get(i);
            Dict dict = buildDict(dictData, dictType);
            dictList.add(dict);
        }

        return dictList;
    }

    /**
     * 构建字字典类型数据
     * @param typeData
     * @return
     */
    private Dict buildDictType(Map typeData) {
        Dict dictType = new Dict();
        dictType.setDictTypeCode((String) typeData.get("code"));
        dictType.setDictTypeName((String) typeData.get("name"));
        dictType.setDictDataCode((String) typeData.get("code"));
        dictType.setDictDataName((String) typeData.get("name"));
        dictType.setSrcType(0);
        dictType.setDictLevel(0);
        return dictType;
    }

    /**
     * 构建字典数据
     * @param typeData
     * @param parentDict
     * @return
     */
    private Dict buildDict(Map typeData, Dict parentDict) {
        Dict dict = new Dict();
        Integer dictLevel = parentDict.getDictLevel() + 1;
        dict.setDictTypeCode(parentDict.getDictTypeCode());
        dict.setDictParentCode(parentDict.getDictDataCode());
        dict.setDictTypeName(parentDict.getDictTypeName());
        dict.setDictDataCode((String) typeData.get("code"));
        dict.setDictDataName((String) typeData.get("name"));
        dict.setSrcType(0);
        dict.setDictLevel(dictLevel);
        return dict;
    }
}
