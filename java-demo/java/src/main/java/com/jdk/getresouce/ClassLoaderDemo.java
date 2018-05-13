package com.jdk.getresouce;


import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;


/**
 * 通过 ClassLoader 获取资源的方式
 *
 * @author liuxilin
 * @date 2018/5/13 16:53
 */
public class ClassLoaderDemo {
    private static final Logger logger = Logger.getLogger(ClassLoaderDemo.class);

    /**
     * ClassLoader.getResourceAsStream() 的方式获取资源
     * 无论要查找的资源前面是否带'/' 都会从classpath的根路径下查找
     */
    @Test
    public void getResourceAsStream() {
//        logger.info(File.pathSeparator); // ;
//        logger.info(File.separator); // \
        // 两种方式都能获取到, 第一种方式要注意不同操作系统的分隔符
        InputStream is1 = ClassLoaderDemo.class.getClassLoader().getResourceAsStream(File.separator + "log4j.properties");
        InputStream is2 = ClassLoaderDemo.class.getClassLoader().getResourceAsStream("log4j.properties");

        logger.info(is1);
        logger.info(is2);
    }

}
