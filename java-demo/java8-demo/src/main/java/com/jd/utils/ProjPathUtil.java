package com.jd.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * 项目路径获取工具类
 * @author liuxilin
 * @date 2022年07月16日 10:16
 */
@Slf4j
public class ProjPathUtil {

    public static void main(String[] args) {
        getPath01();
    }

    /**
     * idea 环境返回路径: /xxx/demo-springcloud/dsc-hoxton/dsc-h-java8/target/classes/ + static + \
     * Linux jar 包部署返回路径:
     * @return
     */
    public static String getPath01(){
        String resourcePath = Thread.currentThread().getContextClassLoader().getResource("").getPath() + "static" + File.separator;
        log.info(resourcePath);
        return resourcePath;
    }
}
