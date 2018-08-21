package com.jdk.clazz.extend;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

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
