package com.demo.springcloud.entity;

import lombok.Data;

@Data
public class Dict {
    private Integer id;

    private Integer parentId;

    private Integer srcType;

    private Integer dictLevel;

    private String dictTypeCode;

    private String dictTypeName;

    private String dictParentCode;

    private String dictDataCode;

    private String dictDataName;

}