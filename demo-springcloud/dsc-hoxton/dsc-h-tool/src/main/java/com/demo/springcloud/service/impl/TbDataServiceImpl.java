package com.demo.springcloud.remote.impl;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.demo.springcloud.config.AppFileConfig;
import com.demo.springcloud.entity.Address;
import com.demo.springcloud.entity.User;
import com.demo.springcloud.remote.FileService;
import com.demo.springcloud.remote.MybatisService;
import com.demo.springcloud.remote.TbDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 *
 * @author liuxilin
 * @date 2022年02月07日 12:55
 */
@Slf4j
@Service("tbDataService")
public class TbDataServiceImpl implements TbDataService {

    @Autowired
    FileService fileService;

    @Autowired
    AppFileConfig appFileConfig;

    @Autowired
    MybatisService mybatisService;


    @Override
    public String saveTbData() {
        String result = "";
        String filePath = fileService.readFileApplicationHome(appFileConfig.getTableExcelFilename());
        File bookFile = new File(filePath);

        saveUsers(bookFile);
        saveAddresses(bookFile);

        return result;
    }

    public void saveUsers(File bookFile){
        ExcelReader excelReader = ExcelUtil.getReader(bookFile, "User");
        List<User> userList = excelReader.readAll(User.class);
        mybatisService.saveUserList(userList);
    }

    public void saveAddresses(File bookFile){
        ExcelReader excelReader = ExcelUtil.getReader(bookFile, "Address");
        List<Address> addressList = excelReader.readAll(Address.class);
        mybatisService.saveAddressList(addressList);
    }
}
