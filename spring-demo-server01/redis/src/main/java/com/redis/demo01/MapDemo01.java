package com.redis.demo01;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map 操作
 *
 * @author liuxl
 * @date 2018/6/14 13:13
 */
public class MapDemo01 {

    /**
     * 存入Map的值
     */
    @Test
    public void hmset() {
        // 连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.80.80");
        //Redis hash 是一个string类型的field和value的映射表，hash特别适合用于存储对象。
        //这里要求的是map必须是key和value都是string类型的
        Map<String, String> map = new HashMap<>();
        map.put("name", "小明");
        map.put("age", "13");
        map.put("sex", "男");
        map.put("height", "174");

        //调用jedis的hmset(存入hash map)的方法将map的键值对存进去
        jedis.hmset("people", map);
    }

    /**
     * map 取值
     */
    @Test
    public void hmget() {
        //连接本地的jedis服务器
        Jedis jedis = new Jedis("192.168.80.80");

        //新建一个string类型的数组,用于存当时存入redis的map的key值
        String[] arr = new String[4];
        arr[0] = "name";
        arr[1] = "age";
        arr[2] = "sex";
        arr[3] = "height";
        //利用jedis的hmget方法,从数据库中依次取出对应的map的key值
        List<String> list = jedis.hmget("people", arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("存入键值对为:" + arr[i] + "--" + list.get(i));
        }
    }
}
