package com.collections;

import java.util.*;

/**
 * @author SUNHAN
 * @Date: 2014年9月29日
 */
public class SIterator {
    public static void main(String[] args) {
        Set set = new HashSet();

        set.add("aa");
        set.add("bb");
        set.add("cc");
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            String str = (String) iter.next();
            System.err.println(str);
        }


        for (Iterator iter1 = set.iterator(); iter.hasNext(); ) {
            String str = (String) iter1.next();
            System.err.println(str);
        }


        List list = new ArrayList();
        list.add("xxx");
        list.add("yyy");
        list.add("zzz");
        for (Object o : list) {
            System.err.println(o.toString());
        }
    }
}