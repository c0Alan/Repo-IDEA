package com.mybatis.model;

public class Address {

    private Integer id;
    private String sheng;
    private String shi;
    private String qu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSheng() {
        return sheng;
    }

    public void setSheng(String sheng) {
        this.sheng = sheng;
    }

    public String getShi() {
        return shi;
    }

    public void setShi(String shi) {
        this.shi = shi;
    }

    public String getQu() {
        return qu;
    }

    public void setQu(String qu) {
        this.qu = qu;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", sheng=" + sheng + ", shi=" + shi
                + ", qu=" + qu + "]";
    }


}