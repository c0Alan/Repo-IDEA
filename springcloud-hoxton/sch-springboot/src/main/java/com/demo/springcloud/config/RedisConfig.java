package com.demo.springcloud.config;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfig {

    @Value("${redis.server:localhost:6379}")
    private String redisServer;

    /**
     * 0:单机,1:哨兵,2:集群
     */
    @Value("${redis.type:0}")
    private Integer redisType;

    @Value("${redis.password:}")
    private String redisPassword;

    @Value("${redis.db:0}")
    private int redisDb;

    public static final int MAX_TOTAL = 100;
    public static final int MAX_IDLE = 5;
    public static final int MIN_IDLE = 5;
    public static final int MAX_WAIT_SECOND = 5;

    public static final int COMMAND_TIMEOUT_SECOND = 5;
    public static final int SHUTDOWN_TIMEOUT_SECOND = 5;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        if (RedisModelEnum.STANDALONE.getModel().equals(redisType)) {
            RedisStandaloneConfiguration config = new RedisStandaloneConfiguration(redisServer.split(":")[0],
                    Integer.parseInt(redisServer.split(":")[1]));
            if (StrUtil.isNotBlank(redisPassword)) {
                config.setPassword(redisPassword);
            }
            return new LettuceConnectionFactory(config, getClientConfig());
        }

        if (RedisModelEnum.SENTINEL.getModel().equals(redisType)) {
            RedisSentinelConfiguration config = new RedisSentinelConfiguration().master("mymaster");
            for (String node : redisServer.split(",")) {
                config.sentinel(new RedisNode(node.split(":")[0], Integer.parseInt(node.split(":")[1])));
            }
            if (StrUtil.isNotBlank(redisPassword)) {
                config.setPassword(redisPassword);
            }
            return new LettuceConnectionFactory(config, getClientConfig());
        }

        if (RedisModelEnum.CLUSTER.getModel().equals(redisType)) {
            RedisClusterConfiguration config = new RedisClusterConfiguration();
            for (String node : redisServer.split(",")) {
                config.clusterNode(new RedisNode(node.split(":")[0], Integer.parseInt(node.split(":")[1])));
            }
            if (StrUtil.isNotBlank(redisPassword)) {
                config.setPassword(redisPassword);
            }
            return new LettuceConnectionFactory(config, getClientConfig());
        }

        return null;

    }

    /*@Bean
    public RedisTemplate<String, Object> redisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory());
        // 配置序列化方式等其他参数
        return template;
    }*/

    @Bean("stringRedisTemplate")
    public StringRedisTemplate stringRedisTemplate() {

        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory());

        return template;
    }

    /**
     * 可以兼容 RedisTemplate<String, String> 类型
     */
    @Bean("redisTemplate")
    public RedisTemplate<String, Object> redisTemplate() {

        RedisTemplate<String, Object> template = new RedisTemplate<>();
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringRedisSerializer);
        template.setHashKeySerializer(stringRedisSerializer);

        // 创建一个ObjectMapper实例，用于处理JSON的序列化和反序列化
        ObjectMapper objectMapper = new ObjectMapper();

        // 设置ObjectMapper的属性访问级别，以便能够序列化对象的所有属性
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        // 启用默认的类型信息，以便在反序列化时能够知道对象的实际类型
        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);

        // 创建一个Jackson2JsonRedisSerializer实例，用于序列化Redis的value为JSON格式, 不用ObjectMapper的话无法反序列化
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        // 设置Jackson2JsonRedisSerializer使用的ObjectMapper
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setConnectionFactory(redisConnectionFactory());
        return template;
    }

    private LettuceClientConfiguration getClientConfig() {
        GenericObjectPoolConfig<RedisConnection> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxTotal(MAX_TOTAL);
        poolConfig.setMaxIdle(MAX_IDLE);
        poolConfig.setMinIdle(MIN_IDLE);
        poolConfig.setMaxWait(Duration.ofSeconds(MAX_WAIT_SECOND));

        LettucePoolingClientConfiguration clientConfiguration = LettucePoolingClientConfiguration.builder()
                .commandTimeout(Duration.ofSeconds(COMMAND_TIMEOUT_SECOND))
                .shutdownTimeout(Duration.ofMillis(SHUTDOWN_TIMEOUT_SECOND))
                .poolConfig(poolConfig).build();

        return clientConfiguration;
    }

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() {
        // 创建配置 指定redis地址及节点信息
        Config config = new Config();

        if (RedisModelEnum.STANDALONE.getModel().equals(redisType)) {
            SingleServerConfig singleServerConfig = config.useSingleServer();
            singleServerConfig.setAddress("redis://" + redisServer).setDatabase(redisDb);
            if (StrUtil.isNotBlank(redisPassword)) {
                singleServerConfig.setPassword(redisPassword);
            }

        }

        return Redisson.create(config);
    }


    enum RedisModelEnum {

        /**
         * 单机模式
         */
        STANDALONE(0, "单机模式"),

        /**
         * 哨兵模式
         */
        SENTINEL(1, "哨兵模式"),

        /**
         * 集群模式
         */
        CLUSTER(2, "集群");

        private Integer model;
        private String desc;

        RedisModelEnum(Integer model, String desc) {
            this.model = model;
            this.desc = desc;
        }

        public Integer getModel() {
            return this.model;
        }

        public String getDesc() {
            return this.desc;
        }
    }
}