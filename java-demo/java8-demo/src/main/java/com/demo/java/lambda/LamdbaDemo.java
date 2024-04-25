package com.demo.java.lambda;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 参考：https://www.cnblogs.com/sinosecurity/p/16846153.html
 *
 * @author liuxilin
 * @date 2023年08月20日 22:22
 */
@Slf4j
public class LamdbaDemo {

    /**
     * 数组遍历
     * @Test 注解下面不能是静态方法，否则没有启动按钮
     */
    @Test
    public void listDemo01() {
        List<String> list = Arrays.asList("a", "b", "c", "d");
        list.stream().forEach((x) -> {
            log.info(x);
        });

    }

}
