package com.lang;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;

public class ObjectUtilsDemo {

    @Test
    public void testToString(){
        Object obj = "abc";
        System.out.println(ObjectUtils.toString(obj));
    }
}
