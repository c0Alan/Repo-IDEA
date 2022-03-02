package com.demo.springcloud.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.ConfigSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.yaml.snakeyaml.Yaml;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liuxilin
 * @date 2022年02月27日 19:48
 */
@Slf4j
@Data
@ConfigurationProperties(prefix = "redission")
@Configuration
public class RedissonConfig {

    Map config;

    @Value("#{'${redis.nodes}'.split(',')}")
    private List<String> nodes;

    @Value("${redis.mode}")
    private Integer mode;

    @PostConstruct
    public void init() {
        log.info(config.toString());
    }

    @Bean
    public RedissonClient redissonClient() throws IOException {
        // Config redissonConfig = Config.fromYAML(RedissonConfig.class.getClassLoader().getResource("redisson-config.yml"));

        Config redissonConfig = null;
        if (mode.equals(Integer.valueOf(2))) {
            redissonConfig = getClusterServersConfig();
        }
        if (mode.equals(Integer.valueOf(0))) {
            redissonConfig = getSingleServerConfig();
        }

        return Redisson.create(redissonConfig);
    }

    private Config getClusterServersConfig() throws IOException {
        Map clusterServersConfig = (Map) config.get("clusterServersConfig");
        config.put("singleServerConfig", null);

        List<String> nodeAddresses = new ArrayList<>();
        nodes.forEach(node -> {
            nodeAddresses.add("redis://" + node);
        });
        clusterServersConfig.put("nodeAddresses", nodeAddresses);
        Config redissonConfig = getRedissonConfig(config);
        return redissonConfig;
    }

    private Config getSingleServerConfig() throws IOException {
        Map singleServerConfig = (Map) config.get("singleServerConfig");
        config.put("clusterServersConfig", null);

        singleServerConfig.put("address", "redis://" + nodes.get(0));

        Config redissonConfig = getRedissonConfig(config);
        return redissonConfig;
    }

    private Config getRedissonConfig(Map config) throws IOException {
        Yaml yaml = new Yaml();
        String content = yaml.dump(config);
        // 这里需要替换掉单引号，不然报错
        content = content.replaceAll("'!<", "!<");
        content = content.replaceAll("\\{\\}'", "{}");
        content = content.replaceAll("''", "null");

        ConfigSupport configSupport = new ConfigSupport();
        Config redissonConfig = configSupport.fromYAML(content, Config.class);
        return redissonConfig;
    }
}
