package com.jd.gauva;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuxilin
 * @date 2022年05月10日 22:22
 */
@Slf4j
public class StringsDemo {

    public static void main(String[] args) {
        demo01();
    }

    public static void demo01(){
        // log.info(String.valueOf(Strings.emptyToNull("").length()));
        String str = Strings.nullToEmpty("aa");
        log.info(str);
        str = Strings.nullToEmpty(null);
        log.info(String.valueOf(str.length()));
    }
}
