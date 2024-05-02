package com.demo.java.modifier.finals;

public class ParentFinalDemo {

    /**
     * 在早期的Java实现版本中，会将final方法转为内嵌调用。
     */
    public final void finalMethod(){
        System.out.println("final method can't be overwrided!");
    }

    class OtherClass extends ParentFinalDemo {

    }
}
