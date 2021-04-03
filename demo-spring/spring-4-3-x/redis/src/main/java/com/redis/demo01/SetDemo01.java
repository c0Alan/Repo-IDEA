package com.redis.demo01;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * Set 实例
 *
 * @author liuxl
 * @date 2018/6/15 12:36
 */
public class SetDemo01 {

    /**
     * 存入Set的值
     * Redis的Set是string类型的无序集合。集合成员是唯一的，这就意味着集合中不能出现重复的数据。
     */
    @Test
    public void sadd() {
        //连接本地的jedis服务器
        Jedis jedis = new Jedis("192.168.80.80");

        //使用list存入数据
        List<String> list = new ArrayList<>();
        list.add("北京");
        list.add("南京");
        list.add("上海");
        list.add("北京");
        list.add("北京");
        list.add("上海");
        list.add("苏州");
        list.add("南京");
        //打印源数据
        System.out.println("源数据为" + list);

        //因为jedis的sadd的方法,存入的是一个数组对象或者多数据,所有将集合对象转换成数组对象
        String[] arr = new String[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        //调用sadd方法存入数据库
        jedis.sadd("city", arr);
    }

    /**
     * set数据的取出
     */
    @Test
    public void smembers() {
        //连接本地的jedis服务器
        Jedis jedis = new Jedis("192.168.80.80");

        //调用jedis的smembers方法,获取所有的set集合
        Set<String> smembers = jedis.smembers("city");

        System.out.println(smembers);
    }

    /**
     * 添加有序集合
     * 有序集合和集合一样也是string类型元素的集合,且不允许重复的成员。
     */
    @Test
    public void zadd() {
        //连接本地的jedis服务器
        Jedis jedis = new Jedis("192.168.80.80");

        Map<String, Double> map = new HashMap<>();
        map.put("北京", 1.0);
        map.put("北京", 2.0);
        map.put("南京", 3.0);
        map.put("上海", 4.0);
        map.put("上海", 5.0);
        map.put("南京", 6.0);

        //调用jedis的zadd方法存入
        jedis.zadd("city2", map);
    }

    /**
     * 获取有序集合
     */
    @Test
    public void zrevrange() {
        //连接本地的jedis服务器
        Jedis jedis = new Jedis("192.168.80.80");

        //索引在0,到10之间的,分数由高到底的取出所有的集合
        Set<String> zrevrange = jedis.zrevrange("city2", 0, 10);
        System.out.println(zrevrange);
    }

}
