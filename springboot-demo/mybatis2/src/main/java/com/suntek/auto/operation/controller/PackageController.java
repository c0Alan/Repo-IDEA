package com.suntek.auto.operation.controller;

import com.suntek.auto.operation.Exception.ErrorCode;
import com.suntek.auto.operation.Exception.OperationException;
import com.suntek.auto.operation.entity.Package;
import com.suntek.auto.operation.service.PackageService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 安装包管理
 * @author tantao
 * @version 2018/9/8
 * @Copyright (C)2018 , Suntektech
 * @since
 */
//@RestController
//@RequestMapping("/package")
public class PackageController {

    private static final Logger LOG = LoggerFactory.getLogger(DeploymentController.class);

    @Autowired
    private PackageService packageService;

    // 上传一个安装包
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String uploadOne() throws Exception {
        packageService.uploadPackage(new Package());
        return "successed";
    }

    // 删除一个安装包
    @RequestMapping(value = "/{packageId}", method = RequestMethod.DELETE)
    public String deleteOne(@PathVariable("packageId") String packageId) {
        if(StringUtils.isBlank(packageId)) {
            throw new OperationException(ErrorCode.INCORRECT_PASSWORD);
        }
        return "successed";
    }

    // 查询所有安装包
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String findAll() {
        return "{\n" +
                "\t\"packageList\":[\n" +
                "\t\t{\n" +
                "\t\t\t\"packageName\": \"20181212#123456#123\",\n" +
                "\t\t\t\"versionType\":\"全量\",\n" +
                "\t\t\t\"deployType\":\"已发布\",\n" +
                "\t\t\t\"useType\":\"未使用\",\n" +
                "\t\t\t\"description\":\"多维视频云V3.5\",\n" +
                "\t\t\t\"creator\":\"张三三\",\n" +
                "\t\t\t\"uploadTime\":\"2018-12-12 10:00:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"packageName\": \"20181212#123456#123\",\n" +
                "\t\t\t\"versionType\":\"增量\",\n" +
                "\t\t\t\"deployType\":\"已发布\",\n" +
                "\t\t\t\"useType\":\"已用\",\n" +
                "\t\t\t\"description\":\"多维视频云V3.5_应用war包\",\n" +
                "\t\t\t\"creator\":\"张三三\",\n" +
                "\t\t\t\"uploadTime\":\"2018-12-12 10:00:00\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"packageName\": \"20181212#123456#123\",\n" +
                "\t\t\t\"versionType\":\"全量\",\n" +
                "\t\t\t\"deployType\":\"未发布\",\n" +
                "\t\t\t\"useType\":\"未使用\",\n" +
                "\t\t\t\"description\":\"多维视频云V3.5_地图war包\",\n" +
                "\t\t\t\"creator\":\"张三三\",\n" +
                "\t\t\t\"uploadTime\":\"2018-12-12 10:00:00\"\n" +
                "\t\t}\n" +
                "\t\t\n" +
                "\t]\n" +
                "}";
    }

}
