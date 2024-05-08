package com.demo.springcloud.utils;

import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZSetDemo {

    private StringRedisTemplate redisTemplate;
    
    public void test1() {
        //向集合中插入元素，并设置分数
        redisTemplate.opsForZSet().add("ranking-list", "p1", 2.1);
        
        //向集合中插入多个元素
        DefaultTypedTuple<String> tuple1 = new DefaultTypedTuple<String>("p2", 1.1);
        DefaultTypedTuple<String> tuple2 = new DefaultTypedTuple<String>("p3", 3.1);
        redisTemplate.opsForZSet().add("ranking-list", new HashSet<>(Arrays.asList(tuple1, tuple2)));
        
        //打印
        printZSet("ranking-list");
    }
    
    public void test2() {
        printZSet("ranking-list");
        //从集合中删除指定元素
        redisTemplate.opsForZSet().remove("ranking-list", "p1");
        printZSet("ranking-list");
    }
    
    public void test3() {
        //为指定元素加分
        Double score = redisTemplate.opsForZSet().incrementScore("ranking-list", "p1", 2);
        System.out.println(score);//返回加分后的得分
        printZSet("ranking-list");
    }
    
    public void test4() {
        //返回指定成员的排名（从小到大）
        Long rank = redisTemplate.opsForZSet().rank("ranking-list", "p1");
        //从大到小
        Long reverseRank = redisTemplate.opsForZSet().reverseRank("ranking-list", "p1");
        System.out.println(rank);
        System.out.println(reverseRank);
    }
    
    public void test5() {
        //返回集合内元素的排名，以及分数（从小到大）
        Set<ZSetOperations.TypedTuple<String>> tuples = redisTemplate.opsForZSet().rangeWithScores("ranking-list", 0, -1);
        for (ZSetOperations.TypedTuple<String> tuple : tuples) {
            System.out.println(tuple.getValue() + " : " + tuple.getScore());
        }
    }
    
    public void test6() {
        //返回集合内元素在指定分数范围内的排名（从小到大）
        Set<String> ranking = redisTemplate.opsForZSet().rangeByScore("ranking-list", 0, 5);
        System.out.println(ranking);
        //带偏移量和个数，下例意为从第二个开始，要三个
        Set<String> ranking2 = redisTemplate.opsForZSet().rangeByScore("ranking-list", 0, 5, 1, 3);
        System.out.println(ranking2);
        //也可以带分数返回，类似于test5
    }
    
    public void test7() {
        //返回集合内指定分数范围的成员个数
        Long count = redisTemplate.opsForZSet().count("ranking-list", 0, 2);
        System.out.println(count);
        //返回集合内的成员个数
        Long size = redisTemplate.opsForZSet().size("ranking-list");//等同于zCard(key);
        System.out.println(size);
    }
    
    public void test8() {
        //获得指定元素的分数
        Double score = redisTemplate.opsForZSet().score("ranking-list", "p1");
        System.out.println(score);
    }
    
    public void test9() {
        //删除指定索引范围的元素
        printZSet("ranking-list");
        redisTemplate.opsForZSet().removeRange("ranking-list", 0, 0);
        printZSet("ranking-list");
    }
    
    public void test10() {
        //删除指定分数范围内的元素
        printZSet("ranking-list");
        redisTemplate.opsForZSet().removeRangeByScore("ranking-list", 4, 5);
        printZSet("ranking-list");
        redisTemplate.opsForZSet();
    }
    
    //求交集并集与set类似
    
    
    private void printZSet(String key) {
        //按照排名先后(从小到大)打印指定区间内的元素, -1为打印全部
        Set<String> range = redisTemplate.opsForZSet().range(key, 0, -1);
        //reverseRange 从大到小 
        System.out.println(range);
    }
    
}