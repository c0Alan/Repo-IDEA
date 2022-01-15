package com.demo.springcloud.entity;

import lombok.Data;

@Data
public class Dict {
    private Integer id;

    private Byte dictLevel;

    private String dictTypeCode;

    private String dictTypeName;

    private String dictDataCode;

    private String dictDataName;

}