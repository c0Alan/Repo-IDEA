package com.demo.java.tools.jmh;

import org.openjdk.jmh.annotations.*;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;


/**
 * 参考：https://mp.weixin.qq.com/s/GOhgce6l7sSYQvRJhPaqMQ
 * @author liuxilin
 * @date 2023-08-05 23:46
 */
@Fork(2)
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
@BenchmarkMode(Mode.Throughput)
public class JedisPoolVSJedisBenchmark {
    JedisPool pool = new JedisPool("172.25.20.57", 6379);

    @Benchmark
    public void testPool() {
        Jedis jedis = pool.getResource();
        jedis.set("a", UUID.randomUUID().toString());
        jedis.close();
    }

    @Benchmark
    public void testJedis() {
        Jedis jedis = new Jedis("172.25.20.57", 6379);
        jedis.set("a", UUID.randomUUID().toString());
        jedis.close();
    }
    //此处省略若干行
}