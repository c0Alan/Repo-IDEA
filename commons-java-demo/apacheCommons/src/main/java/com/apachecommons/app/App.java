package com.apachecommons.app;

import com.apachecommons.beanutils.ACBeanUtils;
import com.apachecommons.chain.ACChain;
import com.apachecommons.codec.ACCodec;
import com.apachecommons.lang.ACLang;
import com.jdk.lang.JLang;
import com.others.jodatime.OJodatime;


public class App {
    
    public static ACLang acLang = new ACLang(); // 测试 Commons lang
    public static ACBeanUtils acBeanUtils = new ACBeanUtils(); // 测试 Commons BeanUtils
    public static ACChain acChain = new ACChain(); // 测试 Commons BeanUtils
    public static ACCodec acCodec = new ACCodec(); // 测试 Commons BeanUtils
    public static JLang jLang = new JLang(); // 测试 Commons lang
    public static OJodatime oJodatime = new OJodatime(); // 测试 Commons lang

    public static void main(String[] args) throws Exception {
//        acLang.testStringUtils();
//        acBeanUtils.testPropertyUtils();
//        acCodec.testBase64();
//        acLang.testArrayUtils();
//        oJodatime.test(); 
    }

}
