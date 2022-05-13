package com.demo.springcloud.gauva;

import com.google.common.base.Optional;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liuxilin
 * @date 2022年05月10日 22:07
 */
@Slf4j
public class OptionalDemo {

    public static void main(String[] args) {
        Demo01();
    }

    /**
     *
     */
    public static void Demo01(){
        Optional<Integer> possible = Optional.of(5);
        // returns true
        boolean b = possible.isPresent();
        log.info(String.valueOf(b));
        // returns 5
        Integer i = possible.get();
        log.info(String.valueOf(i));
    }
}
