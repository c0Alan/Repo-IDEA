
package com.demo.java;

/**
 * @author liuxl
 * @date 2024/5/17
 */
public class C extends B implements A {

    public void m(){
//        System.out.println(this.x);
    }

    public static void main(String[] args) {
        new C().m();
    }

}
