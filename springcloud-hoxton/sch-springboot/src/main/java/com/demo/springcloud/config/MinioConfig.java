package com.demo.springcloud.config;

import com.demo.springcloud.utils.MinioUtils;
import io.minio.MinioClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * minio配置
 *
 * @author liuxl
 * @date 2024/11/17
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinioConfig {

    private String accessKey;
    private String secretKey;
    private String endpoint;
    private String bucketName;

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
    }

    @Bean
    public MinioUtils minioUtils(MinioClient minioClient) {
        return new MinioUtils(minioClient);
    }
}
