package com.jdk.type.string;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式实验类
 *
 * @author liuxl
 * @date 2018/5/31 17:48
 */
public class RegDemo {

    @Test
    public void test01() {
        String str = "fc4a711a6b8effaf007b6d71c6dfe267";
        String reg = "(^|;)(" + str + ")(;|$)";


        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find() && StringUtils.isNotBlank(matcher.group())) {
            System.out.println("matched!");
            return;
        }
        System.out.println("not matched!");
    }
}
