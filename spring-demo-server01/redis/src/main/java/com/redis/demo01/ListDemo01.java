package com.redis.demo01;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * list集合类型操作
 * 
 * @author liuxl
 * @date 2018/6/14 13:05
 */
public class ListDemo01 {

    /**
     * 存入list集合类型的值, 如果 key=城市 已经存在其他类型, 则报错
     */
    @Test
    public void lpush(){
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.80.80");
        //使用字符串list存值
        jedis.lpush("城市", "南京");
        jedis.lpush("城市", "上海");
        jedis.lpush("城市", "苏州");
        jedis.lpush("城市", "北京");
        jedis.lpush("城市", "南通");
    }

    /**
     * list集合取值
     */
    @Test
    public void lrange(){
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.80.80");
        // 获取从下标1, 到下标2的值
        List<String> arr = jedis.lrange("城市", 1, 2);
        for (String string : arr) {
            System.out.println(string);
        }
    }
}
