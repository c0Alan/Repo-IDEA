package com.demo.springcloud.remote.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.demo.springcloud.config.AppFileConfig;
import com.demo.springcloud.entity.User;
import com.demo.springcloud.manager.CacheManager;
import com.demo.springcloud.manager.FelEngineFactory;
import com.demo.springcloud.remote.BaseDataService;
import com.demo.springcloud.remote.FileService;
import com.greenpineyu.fel.FelEngine;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.charset.Charset;
import java.util.*;

/**
 * @author liuxilin
 * @date 2022年02月08日 20:53
 */
@Slf4j
@Service("baseDataService")
public class BaseDataServiceImpl implements BaseDataService {
    @Autowired
    AppFileConfig appFileConfig;

    @Autowired
    FileService fileService;

    @Autowired
    FelEngineFactory felEngineFactory;

    @Autowired
    CacheManager cacheManager;


    @PostConstruct
    private void init() {
        initBaseDataMap();
    }

    @Override
    public String baseDataCache() {
        List<Map<String, Object>> listMap = (List<Map<String, Object>>) cacheManager.getBaseDataMap().get("address");
        Random random = new Random();
        int index = random.nextInt(listMap.size());
        Map<String, Object> map1 = listMap.get(index);
        String district = (String) map1.get("district");

        return district;
    }

    public void initBaseDataMap() {
        String filePath = fileService.readFileApplicationHome(appFileConfig.getBaseDataExcelFilename());

        ExcelReader excelReader = ExcelUtil.getReader(filePath);
        List<Sheet> sheets = excelReader.getSheets();
        for (int i = 0; i < sheets.size(); i++) {
            Sheet sheet = sheets.get(i);
            String sheetName = sheet.getSheetName();
            ExcelReader sheetReader = excelReader.setSheet(sheet);
            List<Map<String, Object>> sheetData = sheetReader.readAll();
            resetNull(sheetData);
            cacheManager.getBaseDataMap().put(sheetName, sheetData);
        }
        excelReader.close();
    }

    /**
     * 将 'null' 字符串转 null 对象
     * @param sheetData
     */
    private void resetNull(List<Map<String, Object>> sheetData){
        sheetData.forEach(data -> {
            data.entrySet().forEach(entry -> {
                String key = entry.getKey();
                Object value = entry.getValue();
                if(value instanceof CharSequence){
                    if (StrUtil.equals("null", (CharSequence) value)){
                        data.put(key, null);
                    }
                }

            });
        });
    }

    @Override
    public User buildUserData() {
        Map data = buildBaseData(appFileConfig.getUserJsonFilename());
        User user = BeanUtil.mapToBean(data, User.class, false, null);

        return user;
    }

    @Override
    public Map buildData(String configFile, int size) {

        if (StrUtil.isBlank(configFile)) {
            return null;
        }
        String filePath = fileService.readFileApplicationHome(configFile);
        JSONObject json = JSONUtil.readJSONObject(new File(filePath), Charset.defaultCharset());
        JSONObject fields = json.getJSONObject("fields");

        Map data = new HashMap();
        data.put("kafka", json.get("kafka"));
        List dataList = new ArrayList();
        data.put("data", dataList);
        for (int i=0; i<size; i++) {
            Map baseData = buildBaseData(fields);
            dataList.add(baseData);
        }

        return data;
    }

    private Map buildBaseData(String configFile) {
        String filePath = fileService.readFileApplicationHome(configFile);
        JSONObject json = JSONUtil.readJSONObject(new File(filePath), Charset.defaultCharset());
        JSONObject fields = json.getJSONObject("fields");

        Map baseData = buildBaseData(fields);
        return baseData;
    }

    private Map buildBaseData(JSONObject fields) {
        Map baseData = new HashMap();
        FelEngine felEngine = null;
        try {
            felEngine = felEngineFactory.borrowObject();
        } catch (Exception e) {
            log.error("获取felEngine对象失败: {}", e);
        }

        for (Map.Entry<String, Object> entry : fields.entrySet()) {
            String fieldName = entry.getKey();
            String expression = (String) entry.getValue();
            Object value = felEngine.eval(expression);
            baseData.put(fieldName, value);
        }

        try {
            felEngineFactory.returnObject(felEngine);
        } catch (Exception e) {
            log.error("释放felEngine对象失败: {}", e);
        }
        return baseData;
    }

    @Override
    public List<User> buildUserList(int size) {
        if (size <= 0) {
            return null;
        }
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            User user = buildUserData();
            userList.add(user);
        }
        return userList;
    }

}
