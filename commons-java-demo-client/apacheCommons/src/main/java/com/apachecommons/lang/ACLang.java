package com.apachecommons.lang;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * apache commons lang 包测试类
 * 
 * @author liuxl
 * 2017-9-27 下午2:10:17
 */
public class ACLang {
    
    Logger logger = Logger.getLogger(ACLang.class);
    
//    ArrayUtils – 用于对数组的操作，如添加、查找、删除、子数组、倒序、元素类型转换等；
//    BitField – 用于操作位元，提供了一些方便而安全的方法；
//    BooleanUtils – 用于操作和转换boolean或者Boolean及相应的数组；
//    CharEncoding – 包含了Java环境支持的字符编码，提供是否支持某种编码的判断；
//    CharRange – 用于设定字符范围并做相应检查；
//    CharSet – 用于设定一组字符作为范围并做相应检查；
//    CharSetUtils – 用于操作CharSet；
//    CharUtils – 用于操作char值和Character对象；
//    ClassUtils – 用于对Java类的操作，不使用反射；
//    ObjectUtils – 用于操作Java对象，提供null安全的访问和其他一些功能；
//    RandomStringUtils – 用于生成随机的字符串；
//    SerializationUtils – 用于处理对象序列化，提供比一般Java序列化更高级的处理能力；
//    StringEscapeUtils – 用于正确处理转义字符，产生正确的Java、JavaScript、HTML、XML和SQL代码；
//    StringUtils – 处理String的核心类，提供了相当多的功能；
//    SystemUtils – 在java.lang.System基础上提供更方便的访问，如用户路径、Java版本、时区、操作系统等判断；
//    Validate – 提供验证的操作，有点类似assert断言；
//    WordUtils – 用于处理单词大小写、换行等。
    
    /**
     * 测试  StringUtils 类
     * 
     * 2017-9-27 下午2:13:08
     */
    public void testStringUtils(){
        String str = "abc";
        
        boolean isEmpty = StringUtils.isEmpty(str); // 判断字符串是否为空
        System.out.println(isEmpty);
        
    }
    
    /**
     * 测试  ArrayUtils 类
     * 
     * @author liuxl
     * @date @time 2017-10-11 下午1:30:58
     */
    public void testArrayUtils(){
//       int len = ArrayUtils.getLength(null);
       Object[] array = null;
       boolean b = ArrayUtils.isEmpty(array);
       logger.info(b);
    }

}
