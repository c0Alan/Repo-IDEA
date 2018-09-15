package com.suntek.auto.operation.controller;

import com.suntek.auto.operation.config.AuthorSettings;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 部署日志
 * @author tantao
 * @version 2018/9/8
 * @Copyright (C)2018 , Suntektech
 * @since
 */
@RestController
@RequestMapping("/deployment/log")
public class DeploymentLogController {

    private static final Logger LOG = LoggerFactory.getLogger(DeploymentLogController.class);

    @Autowired
    private AuthorSettings authorSettings;

    // 查询所有部署日志
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String findAll() {
        return "{\n" +
                "\t\"logList\":[\n" +
                "\t\t{\n" +
                "\t\t\t\"logDate\": \"2018-12-12\",\n" +
                "\t\t\t\"operateList\":[\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"operate\":\"add\",\n" +
                "\t\t\t\t\t\"operateName\":\"添加主机\",\n" +
                "\t\t\t\t\t\"operator\":\"张三三\",\n" +
                "\t\t\t\t\t\"operateTime\":\"2018-12-12 10:00:00\",\n" +
                "\t\t\t\t\t\"description\":\"添加主机(10)\",\n" +
                "\t\t\t\t\t\"remark\":\"\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"operate\":\"delete\",\n" +
                "\t\t\t\t\t\"operateName\":\"删除主机\",\n" +
                "\t\t\t\t\t\"operator\":\"张三三\",\n" +
                "\t\t\t\t\t\"operateTime\":\"2018-12-12 10:00:00\",\n" +
                "\t\t\t\t\t\"description\":\"删除主机(10)\",\n" +
                "\t\t\t\t\t\"remark\":\"\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"operate\":\"stop\",\n" +
                "\t\t\t\t\t\"operateName\":\"停止主机\",\n" +
                "\t\t\t\t\t\"operator\":\"张三三\",\n" +
                "\t\t\t\t\t\"operateTime\":\"2018-12-12 10:00:00\",\n" +
                "\t\t\t\t\t\"description\":\"停止主机(10)\",\n" +
                "\t\t\t\t\t\"remark\":\"停止正常运行组件的主机\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"logDate\": \"2018-12-10\",\n" +
                "\t\t\t\"operateList\":[\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"operate\":\"deployment\",\n" +
                "\t\t\t\t\t\"operateName\":\"模块部署\",\n" +
                "\t\t\t\t\t\"operator\":\"张三三\",\n" +
                "\t\t\t\t\t\"operateTime\":\"2018-12-12 10:00:00\",\n" +
                "\t\t\t\t\t\"description\":\"模块部署(2)\",\n" +
                "\t\t\t\t\t\"remark\":\"\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"operate\":\"update\",\n" +
                "\t\t\t\t\t\"operateName\":\"模块升级\",\n" +
                "\t\t\t\t\t\"operator\":\"张三三\",\n" +
                "\t\t\t\t\t\"operateTime\":\"2018-12-12 10:00:00\",\n" +
                "\t\t\t\t\t\"description\":\"模块升级(10)\",\n" +
                "\t\t\t\t\t\"remark\":\"升级异常，未解决\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"operate\":\"move\",\n" +
                "\t\t\t\t\t\"operateName\":\"模块迁移\",\n" +
                "\t\t\t\t\t\"operator\":\"张三三\",\n" +
                "\t\t\t\t\t\"operateTime\":\"2018-12-12 10:00:00\",\n" +
                "\t\t\t\t\t\"description\":\"模块迁移(3)\",\n" +
                "\t\t\t\t\t\"remark\":\"模块迁移异常，未解决\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"operate\":\"plan_update\",\n" +
                "\t\t\t\t\t\"operateName\":\"方案变更\",\n" +
                "\t\t\t\t\t\"operator\":\"张三三\",\n" +
                "\t\t\t\t\t\"operateTime\":\"2018-12-12 10:00:00\",\n" +
                "\t\t\t\t\t\"description\":\"方案变更(3)\",\n" +
                "\t\t\t\t\t\"remark\":\"\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
    }

    // 按日期段查询所有部署日志
    @RequestMapping(value = "/list/{startDate}/{endDate}", method = RequestMethod.GET)
    public String findByDate(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) throws Exception {
        if(StringUtils.isBlank(startDate) && StringUtils.isBlank(endDate)) {
            throw new Exception("开始时间和结束时间必选其一");
        }
        LOG.debug("开始时间:{}, 结束时间:{}", startDate, endDate);
        return "{\n" +
                "\t\"logList\":[\n" +
                "\t\t{\n" +
                "\t\t\t\"logDate\": \"2018-12-12\",\n" +
                "\t\t\t\"operateList\":[\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"operate\":\"add\",\n" +
                "\t\t\t\t\t\"operateName\":\"添加主机\",\n" +
                "\t\t\t\t\t\"operator\":\"张三三\",\n" +
                "\t\t\t\t\t\"operateTime\":\"2018-12-12 10:00:00\",\n" +
                "\t\t\t\t\t\"description\":\"添加主机(10)\",\n" +
                "\t\t\t\t\t\"remark\":\"\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"operate\":\"delete\",\n" +
                "\t\t\t\t\t\"operateName\":\"删除主机\",\n" +
                "\t\t\t\t\t\"operator\":\"张三三\",\n" +
                "\t\t\t\t\t\"operateTime\":\"2018-12-12 10:00:00\",\n" +
                "\t\t\t\t\t\"description\":\"删除主机(10)\",\n" +
                "\t\t\t\t\t\"remark\":\"\"\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"operate\":\"stop\",\n" +
                "\t\t\t\t\t\"operateName\":\"停止主机\",\n" +
                "\t\t\t\t\t\"operator\":\"张三三\",\n" +
                "\t\t\t\t\t\"operateTime\":\"2018-12-12 10:00:00\",\n" +
                "\t\t\t\t\t\"description\":\"停止主机(10)\",\n" +
                "\t\t\t\t\t\"remark\":\"停止正常运行组件的主机\"\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
    }

}
