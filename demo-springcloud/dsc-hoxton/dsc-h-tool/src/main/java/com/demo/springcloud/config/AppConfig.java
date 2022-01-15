package com.demo.springcloud.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * xxl-job config
 *
 * @author xuxueli 2017-04-28
 */
@Configuration
@Slf4j
@RefreshScope
@Data
public class AppConfig {

    @Value("${app.read-file-path:file/read}")
    private String readFilePath;

    @Value("#{systemProperties['appHomeDir']}")
    private String appHomeDir;

}