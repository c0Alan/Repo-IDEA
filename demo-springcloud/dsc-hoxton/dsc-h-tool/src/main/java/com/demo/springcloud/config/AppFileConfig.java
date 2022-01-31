package com.demo.springcloud.config;

import cn.hutool.core.util.StrUtil;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.util.List;

/**
 * xxl-job config
 *
 * @author xuxueli 2017-04-28
 */
@Configuration
@Slf4j
@RefreshScope
@Data
public class AppFileConfig {

    /** 获取 java -D 系统配置参数 */
    @Value("#{systemProperties['appHomeDir']}")
    private String appHomeDir;

    @Getter
    @Value("${app.file.read-path:file/read}")
    private String readPath;

    @Value("${app.file.read-path:file/write}")
    private String writePath;

    @Value("${app.file.filename.user-json:user.json}")
    private String userJsonFilename;

    @Value("${app.file.filename.xzqh-excel:行政区划数据.xlsx}")
    private String xzqhExcelFilename;

    @Value("${app.file.filename.dict-excel:字典数据.xlsx}")
    private String dictExcelFilename;

    @Value("${app.file.filename.dict-excel-sheets}")
    private List<String> dictExcelSheets;

    /**
     * 由于加了@Data注解，所以该方法不生效的
     * @param readPath
     */
    public void setReadPath(String readPath) {
        this.readPath = StrUtil.replace(readPath, "/", File.separator);
    }
}