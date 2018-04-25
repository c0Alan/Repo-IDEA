package com.redis.util;


import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * 测试 Redis 分布式锁
 *
 * @author liuxilin
 * @date 2018/4/25 21:38
 */
public class RedisTool {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";
    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 尝试获取分布式锁, 正确示例
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     *
     * 第一个为key，我们使用key来当锁，因为key是唯一的。
     *
     * 第二个为value，我们传的是requestId，很多童鞋可能不明白，有key作为锁不就够了吗，
     * 为什么还要用到value？原因就是我们在上面讲到可靠性时，
     * 分布式锁要满足第四个条件解铃还须系铃人，通过给value赋值为requestId，
     * 我们就知道这把锁是哪个请求加的了，在解锁的时候就可以有依据。
     * requestId可以使用UUID.randomUUID().toString()方法生成。
     *
     * 第三个为nxxx，这个参数我们填的是NX，意思是SET IF NOT EXIST，即当key不存在时，
     * 我们进行set操作；若key已经存在，则不做任何操作；
     *
     * 第四个为expx，这个参数我们传的是PX，意思是我们要给这个key加一个过期的设置，
     * 具体时间由第五个参数决定。
     *
     * 第五个为time，与第四个参数相呼应，代表key的过期时间。
     * @return 是否获取成功
     */
    public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {

        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        if (LOCK_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

    /**
     * 错误示例1
     * 比较常见的错误示例就是使用jedis.setnx()和jedis.expire()组合实现加锁
     *
     * @param jedis
     * @param lockKey
     * @param requestId
     * @param expireTime
     */
    public static void wrongGetLock1(Jedis jedis, String lockKey, String requestId, int expireTime) {

        Long result = jedis.setnx(lockKey, requestId);
        if (result == 1) {
            // 若在这里程序突然崩溃，则无法设置过期时间，将发生死锁
            jedis.expire(lockKey, expireTime);
        }

    }

    /**
     * 错误示例2
     *
     * @param jedis
     * @param lockKey
     * @param expireTime
     * @return
     */
    public static boolean wrongGetLock2(Jedis jedis, String lockKey, int expireTime) {

        long expires = System.currentTimeMillis() + expireTime;
        String expiresStr = String.valueOf(expires);

        // 如果当前锁不存在，返回加锁成功
        if (jedis.setnx(lockKey, expiresStr) == 1) {
            return true;
        }

        // 如果锁存在，获取锁的过期时间
        String currentValueStr = jedis.get(lockKey);
        if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
            // 锁已过期，获取上一个锁的过期时间，并设置现在锁的过期时间
            String oldValueStr = jedis.getSet(lockKey, expiresStr);
            if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                // 考虑多线程并发的情况，只有一个线程的设置值和当前值相同，它才有权利加锁
                return true;
            }
        }

        // 其他情况，一律返回加锁失败
        return false;

    }

    /**
     * 释放分布式锁, 正确方式
     * Lua脚本代码，首先获取锁对应的value值，
     * 检查是否与requestId相等，如果相等则删除锁（解锁）, 确保操作是原子性的
     * @param jedis Redis客户端
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }
        return false;

    }

    /**
     * 错误示例1
     * @param jedis
     * @param lockKey
     */
    public static void wrongReleaseLock1(Jedis jedis, String lockKey) {
        jedis.del(lockKey);
    }

    /**
     * 错误示例2
     * @param jedis
     * @param lockKey
     * @param requestId
     */
    public static void wrongReleaseLock2(Jedis jedis, String lockKey, String requestId) {

        // 判断加锁与解锁是不是同一个客户端
        if (requestId.equals(jedis.get(lockKey))) {
            // 若在此时，这把锁突然不是这个客户端的，则会误解锁
            jedis.del(lockKey);
        }

    }

}