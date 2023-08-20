package com.sch.util;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

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
     *
     * @return
     */
    public static Date randomBirthdate() {
        return RandomUtil.randomDay(0, -10000).toJdkDate();
    }

    public static Object randomEle(String dictList, String isRandomNull) {
        if (isReturnNull(isRandomNull)) {
            return null;
        }
        return RandomUtil.randomEle(dictList.split(","));
    }

    private static boolean isReturnNull(String isRandomNull) {
        if (StrUtil.isNotBlank(isRandomNull)) {
            if (StrUtil.equals("true", isRandomNull)) {
                int i = RandomUtil.randomInt(1, 3);
                if (i == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
