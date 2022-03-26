package com.demo.springcloud.util;

import cn.hutool.core.util.RandomUtil;

import java.util.Date;

/**
 * 随机数据工具类
 *
 * @author liuxilin
 * @date 2022年03月20日 22:35
 */
public class RandomDataUtil {

    /**
     * 生成随机生日
     * @return
     */
    public static Date randomBirthdate(){
        return RandomUtil.randomDay(0, -10000).toJdkDate();
    }

    public static Object randomEle(String dictList) {
       return RandomUtil.randomEle( dictList.split(","));
    }
}
