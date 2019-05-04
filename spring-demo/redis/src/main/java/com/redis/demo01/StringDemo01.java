package com.redis.demo01;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * String类型操作实验
 * 
 * @author liuxl
 * @date 2018/6/14 12:59
 */
public class StringDemo01 {

    /**
     * 连接
     */
    @Test
    public void connect(){
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.80.80");
        System.out.println("连接成功");
        // 查看服务是否运行
        System.out.println("服务正在运行: " + jedis.ping());
    }

    /**
     * 字符串操作
     */
    @Test
    public void setString(){
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.80.80");
        //使用字符串string存值
        String result = jedis.set("城市", "南京");
        System.out.println(result); // OK
    }

    /**
     * 字符串操作
     */
    @Test
    public void getString(){
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.80.80");
        String city = jedis.get("城市");
        System.out.println(city); // 南京
    }

}
