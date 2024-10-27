package com.demo.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 参考: https://blog.csdn.net/chengyuqiang/article/details/102938266
 *
 * @author liuxilin
 * @date 2022/3/12 23:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document(indexName = "idx_doc", type = "_doc", shards = 1, replicas = 0)
public class ElasticsearchDoc {

    @Id
    private Long id;


    @Field(type = FieldType.Keyword)
    private String title;

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;

}