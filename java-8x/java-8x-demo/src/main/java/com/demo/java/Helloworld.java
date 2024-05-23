package com.demo.java;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxilin
 * @since 2023-07-30
 */
@Slf4j
public class Helloworld {
    public static void main(String[] args) {
        String[] strArr = {"aioodsc", "ieoadb", "aidscoo", "dbieoa", "dioibii"};
        Map<String, ArrayList> map = new HashMap();
        for (String str : strArr){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortSting = Arrays.toString(charArray);
            ArrayList list = map.get(sortSting);
            if (list == null){
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(sortSting, list);
        }

        for (ArrayList list : map.values()){
            System.out.println(list);
        }
    }
}
