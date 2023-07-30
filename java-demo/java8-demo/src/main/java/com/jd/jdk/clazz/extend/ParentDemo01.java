package com.jd.jdk.clazz.extend;

import java.util.ArrayList;
import java.util.List;

public class ParentDemo01 {

    List list = new ArrayList<>();

    protected String name = "parent";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printList(){
        System.out.println(list);
    }
}
