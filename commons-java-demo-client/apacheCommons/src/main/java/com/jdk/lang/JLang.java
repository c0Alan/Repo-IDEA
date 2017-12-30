package com.jdk.lang;

import org.apache.log4j.Logger;

/**
 * jdk lang 包测试
 * 
 * @author liuxl
 * 2017-9-27 下午2:34:19
 */
public class JLang {
    private static Logger logger = Logger.getLogger(JLang.class);

    /**
     * 测试 String 类
     * 
     * 2017-9-27 下午2:34:49
     */
    public void testString(){
        
        /** matches 函数: String 的正则表达式匹配 */
//        String str1 = null;
        String str1 = "aaa.bbb_dd_gg";
        String str2 = "aaa.bbb_dd_kk";
        boolean result = str1.matches("aaa\\.bbb_.*_gg");
        logger.info("" + result);
        result = str2.matches("aaa\\.bbb_.*_gg");
        logger.info("" + result);
        
    }
}
