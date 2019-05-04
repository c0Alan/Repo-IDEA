package com.springmvc.model;

/***
 * Address 实体测试类
 *
 * @author liuxl
 * @date 2018/4/27 13:05
 */
public class Address {

    private String province;

    private String city;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address [province=" + province + ", city=" + city + "]";
    }

}