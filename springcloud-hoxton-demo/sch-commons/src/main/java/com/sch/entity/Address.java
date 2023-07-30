package com.sch.entity;

import lombok.Data;


@Data
public class Address {
    private Integer id;

    private String province;

    private String city;

    private String district;

    private String address;

}