package com.demo.java.web.i18n;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 编程实现固定文本的国际化
 * 
 * @author liuxilin
 * @date 2018/5/5 10:39
 */
public class I18NDemo {

    @Test
    public void test() throws UnsupportedEncodingException {
        //资源包基名(包名+myproperties)
        String basename = "myproperties";
        //设置语言环境
        Locale cn = Locale.CHINA;//中文, 读取 myproperties_zh.properties 文件
        Locale us = Locale.US;//英文, 读取 myproperties_en.properties 文件
        //根据基名和语言环境加载对应的语言资源文件
        ResourceBundle myResourcesCN = ResourceBundle.getBundle(basename, cn);//加载myproperties_zh.properties
        ResourceBundle myResourcesUS = ResourceBundle.getBundle(basename, us);//加载myproperties_en.properties

        //加载资源文件后， 程序就可以调用ResourceBundle实例对象的 getString方法获取指定的资源信息名称所对应的值。
        //String value =  myResources.getString(“key");
        String usernameCN = myResourcesCN.getString("username");
        String passwordCN = myResourcesCN.getString("password");

        String usernameUS = myResourcesUS.getString("username");
        String passwordUS = myResourcesUS.getString("password");

        System.out.println(usernameCN + "--" + passwordCN);
        System.out.println(usernameUS + "--" + passwordUS);
    }
}