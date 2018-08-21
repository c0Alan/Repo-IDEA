package com.jdk.clazz.extend;

public class ChildDemo01 extends ParentDemo01 implements IParentDemo01 {
    {
        name = "child";
        list.add("ChildDemo01");
    }

    public static void main(String[] args) {
        IParentDemo01 demo01 = new ChildDemo01();
        System.out.println(demo01.getName()); // child
    }
}
