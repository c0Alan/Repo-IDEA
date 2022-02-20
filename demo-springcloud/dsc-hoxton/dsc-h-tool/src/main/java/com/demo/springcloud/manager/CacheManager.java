package com.demo.springcloud.manager;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.demo.springcloud.config.AppFileConfig;
import com.demo.springcloud.service.FileService;
import lombok.Data;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 缓存管理类
 * @author liuxilin
 * @date 2022年02月13日 21:06
 */
@Data
@Service
public class CacheManager {
    @Autowired
    AppFileConfig appFileConfig;

    @Autowired
    FileService fileService;

    Map<String, Object> baseDataMap = new HashMap<>();

    @PostConstruct
    private void init() {
        initBaseDataMap();
    }

    /**
     * 将《基础数据.xlsx》文件内容加载为缓存数据
     */
    public void initBaseDataMap(){
        String filePath = fileService.readFileApplicationHome(appFileConfig.getBaseDataExcelFilename());

        ExcelReader excelReader = ExcelUtil.getReader(filePath);
        List<Sheet> sheets = excelReader.getSheets();
        for (int i = 0; i < sheets.size(); i++) {
            Sheet sheet = sheets.get(i);
            String sheetName = sheet.getSheetName();
            ExcelReader sheetReader = excelReader.setSheet(sheet);
            List<Map<String, Object>> sheetData = sheetReader.readAll();
            baseDataMap.put(sheetName, sheetData);
        }
        excelReader.close();
    }
}
