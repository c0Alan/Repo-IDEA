package com.demo.java.reactive;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

/**
 * 响应式编程 Reactor 3 示例
 * Reactor3 中文文档：https://www.cnblogs.com/crazymakercircle/p/14292098.html
 * @author liuxl
 * @date 2024/7/28
 */
@Slf4j
public class ReactorDemo {


    /**
     * https://www.cnblogs.com/crazymakercircle/p/14292098.html
     * 4.3. 简单的创建和订阅 Flux 或 Mono 的方法
     */
    @Test
    public void test01() {
        Flux<String> seq1 = Flux.just("foo", "bar", "foobar");
        seq1.subscribe(System.out::println);
        List<String> iterable = Arrays.asList("foo", "bar", "foobar");
        Flux<String> seq2 = Flux.fromIterable(iterable);
        seq2.subscribe(System.out::println);

        Mono<String> noData = Mono.empty();
        noData.subscribe(System.out::println);
        Mono<String> data = Mono.just("foo");
        data.subscribe(System.out::println);
        Flux<Integer> numbersFromFiveToSeven = Flux.range(5, 3);
        numbersFromFiveToSeven.subscribe(i -> log.info(i + ""));

    }
}
