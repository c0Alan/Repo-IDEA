package com.jdk.foreach;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class ForEachDemo {
     private static final Logger logger = Logger.getLogger(ForEachDemo.class);
    /**
     * 利用foreach制作死循环 (失败)
     * foreach 中改变list的引用并不对foreach起作用
     */
    @Test
    public void recursive(){
        TestCollection coll01 = new TestCollection("coll01");
        TestCollection coll02 = new TestCollection("coll02");
        TestCollection coll03 = new TestCollection("coll03");

        coll01.getSubCollections().add(coll01);
        coll01.getSubCollections().add(coll02);
        coll01.getSubCollections().add(coll03);

        coll02.getSubCollections().add(coll01);
        coll02.getSubCollections().add(coll02);
        coll02.getSubCollections().add(coll01);

        List<TestCollection> list = coll01.getSubCollections();

        for (TestCollection coll : list){
            logger.info(coll);
            if(coll.getName().equals("coll02")){
                list = coll.getSubCollections();
                logger.info(list);
            }
        }

    }
}
