package com.sch;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 执行 main 方法，控制台输入模块表名，回车自动生成对应项目目录中
 *
 * @author liuxilin
 * @date 2023-08-15 22:38
 */
public class MybatisPlusCodeGenerator {

    public static void main(String[] args) {
        //====================配置变量区域=====================//
        //生成文件的作者，可以不填
        String author = "liuxilin";
        //生成的entity、controller、service等包所在的公共上一级包路径全限定名
        String rootPackage = "com.sch";
        String moduleName = "sch-demo";
        //数据库配置
        String url = "jdbc:mysql://172.25.22.93:3306/db_dsc?useUnicode=true&characterEncoding=utf8&useSSL=false&allowMultiQueries=true";
        //或者com.mysql.cj.jdbc.Driver
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String username = "videoweb";
        String password = "suntek";
        //表名，多个使用,分隔
        String tableNames = "t_user";
        //====================配置变量区域=====================//

        // 代码生成器
        AutoGenerator generator = new AutoGenerator();
        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(projectPath + "/springcloud-hoxton-demo/" + moduleName + "/src/main/java");
        //是否覆盖已有文件，默认false
        globalConfig.setFileOverride(false);
        //是否打开输出目录
        globalConfig.setOpen(false);
        globalConfig.setAuthor(author);
        //去掉service接口的首字母I
        globalConfig.setServiceName("%sService");
        //开启 BaseResultMap
        globalConfig.setBaseResultMap(true);
        //只使用 java.util.date代替
        globalConfig.setDateType(DateType.ONLY_DATE);
        //分配ID (主键类型为number或string）
        globalConfig.setIdType(IdType.AUTO);
        generator.setGlobalConfig(globalConfig);

        // 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl(url);
        //数据库类型
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName(driverClassName);
        dataSourceConfig.setUsername(username);
        dataSourceConfig.setPassword(password);
        generator.setDataSource(dataSourceConfig);

        // 包配置
        PackageConfig packageConfig = new PackageConfig();
        //packageConfig.setModuleName(scanner("模块名"));
        //例：org.jeecg.modules.xqxy
        packageConfig.setParent(rootPackage);
        generator.setPackageInfo(packageConfig);

        //注意：模板引擎在mybatisplus依赖中的templates目录下，可以依照此默认模板进行自定义

        // 策略配置：配置根据哪张表生成代码
        StrategyConfig strategy = new StrategyConfig();
        //表名，多个英文逗号分割（与exclude二选一配置）
        strategy.setInclude(tableNames);
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        //lombok模型，@Accessors(chain = true)setter链式操作
        strategy.setEntityLombokModel(true);
        //controller生成@RestController
        strategy.setRestControllerStyle(true);
        //是否生成实体时，生成字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);

        generator.setStrategy(strategy);
        generator.setTemplateEngine(new FreemarkerTemplateEngine());
        generator.execute();
    }

}