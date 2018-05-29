package com.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Log4jDemo {
    private static Logger logger = Logger.getLogger(Log4jDemo.class);

    /**
     * 打印不同级别日志
     */
    @Test
    public void level() {
        logger.debug("debug test");
        logger.info("info test");
        logger.error("error test");
    }

    /**
     * 打印列表
     */
    @Test
    public void printList(){
        List<Object> params = new ArrayList<Object>();
        params.add("aaa");
        params.add(123);
        logger.error(params); // [aaa, 123]
    }

    /**
     * 数组不能打印元素
     */
    @Test
    public void arrayLog(){
        int[] arr = {1, 2, 3};
        logger.info(arr); // [I@762efe5d
    }

    @Test
    public void mapLog(){
        Map map = new HashMap();
        map.put("aa", "aa");
        logger.info(map); // {aa=aa}
    }
}
