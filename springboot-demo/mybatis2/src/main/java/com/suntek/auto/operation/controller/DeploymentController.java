package com.suntek.auto.operation.controller;

import com.suntek.auto.operation.config.AuthorSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 平台部署
 * @author tantao
 * @version 2018/9/8
 * @Copyright (C)2018 , Suntektech
 * @since
 */
@RestController
@RequestMapping("/deployment")
public class DeploymentController {

    private static final Logger LOG = LoggerFactory.getLogger(DeploymentController.class);

    @Autowired
    private AuthorSettings authorSettings;

    // 统计部署主机的总数量，各种状态的数量

    // 查询所有部署主机
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String findAll() {
        return "{\n" +
                "\t\"projectName\":\"广东省公安厅2017-174视频云项目之工程一\",\n" +
                "\t\"serverCount\":3,\n" +
                "\t\"runningCount\":3,\n" +
                "\t\"errorCount\":0,\n" +
                "\t\"stopCount\":0,\n" +
                "\t\"serverList\":[\n" +
                "\t\t{\n" +
                "\t\t\t\"serverName\": \"ServerName-1\",\n" +
                "\t\t\t\"os\":\"CentOS 7.2\",\n" +
                "\t\t\t\"ip\":\"192.168.0.1\",\n" +
                "\t\t\t\"cpu\":\"16核32线程E5-2640V4 2.4HZ\",\n" +
                "\t\t\t\"memory\":\"64GB DDR4 2400MHz\",\n" +
                "\t\t\t\"disk\":\"2*300GB SAS, 2*1TB SATA\",\n" +
                "\t\t\t\"componentCount\": 6,\n" +
                "\t\t\t\"componentList\":[\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"componentName\":\"mysql\",\n" +
                "\t\t\t\t\t\"status\":\"running\",\n" +
                "\t\t\t\t\t\"count\":1\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"componentName\":\"redis_c\",\n" +
                "\t\t\t\t\t\"status\":\"running\",\n" +
                "\t\t\t\t\t\"count\":3\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"componentName\":\"a-tomcat\",\n" +
                "\t\t\t\t\t\"status\":\"running\",\n" +
                "\t\t\t\t\t\"count\":1\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"componentName\":\"b-tomcat\",\n" +
                "\t\t\t\t\t\"status\":\"running\",\n" +
                "\t\t\t\t\t\"count\":1\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"serverName\": \"ServerName-2\",\n" +
                "\t\t\t\"os\":\"CentOS 7.2\",\n" +
                "\t\t\t\"ip\":\"192.168.0.1\",\n" +
                "\t\t\t\"cpu\":\"16核32线程E5-2640V4 2.4HZ\",\n" +
                "\t\t\t\"memory\":\"64GB DDR4 2400MHz\",\n" +
                "\t\t\t\"disk\":\"2*300GB SAS, 2*1TB SATA\",\n" +
                "\t\t\t\"componentCount\": 6,\n" +
                "\t\t\t\"componentList\":[\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"componentName\":\"mysql\",\n" +
                "\t\t\t\t\t\"status\":\"running\",\n" +
                "\t\t\t\t\t\"count\":1\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"componentName\":\"redis_c\",\n" +
                "\t\t\t\t\t\"status\":\"running\",\n" +
                "\t\t\t\t\t\"count\":3\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"componentName\":\"a-tomcat\",\n" +
                "\t\t\t\t\t\"status\":\"error\",\n" +
                "\t\t\t\t\t\"count\":1\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"componentName\":\"b-tomcat\",\n" +
                "\t\t\t\t\t\"status\":\"stop\",\n" +
                "\t\t\t\t\t\"count\":1\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"serverName\": \"ServerName-3\",\n" +
                "\t\t\t\"os\":\"CentOS 7.2\",\n" +
                "\t\t\t\"ip\":\"192.168.0.1\",\n" +
                "\t\t\t\"cpu\":\"16核32线程E5-2640V4 2.4HZ\",\n" +
                "\t\t\t\"memory\":\"64GB DDR4 2400MHz\",\n" +
                "\t\t\t\"disk\":\"2*300GB SAS, 2*1TB SATA\",\n" +
                "\t\t\t\"componentCount\": 6,\n" +
                "\t\t\t\"componentList\":[\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"componentName\":\"mysql\",\n" +
                "\t\t\t\t\t\"status\":\"error\",\n" +
                "\t\t\t\t\t\"count\":1\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"componentName\":\"redis_c\",\n" +
                "\t\t\t\t\t\"status\":\"error\",\n" +
                "\t\t\t\t\t\"count\":3\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"componentName\":\"a-tomcat\",\n" +
                "\t\t\t\t\t\"status\":\"error\",\n" +
                "\t\t\t\t\t\"count\":1\n" +
                "\t\t\t\t},\n" +
                "\t\t\t\t{\n" +
                "\t\t\t\t\t\"componentName\":\"b-tomcat\",\n" +
                "\t\t\t\t\t\"status\":\"error\",\n" +
                "\t\t\t\t\t\"count\":1\n" +
                "\t\t\t\t}\n" +
                "\t\t\t]\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
    }

    // 查询主机里部署的组件信息

    // 导出所有部署主机的信息

}
