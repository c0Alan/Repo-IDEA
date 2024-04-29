package com.demo.java.designpatterns.behaviour.iterator;

/**
 * Iterator 迭代子模式指示一个访问集合元素的对象，它给客户端提供一种顺序访问集合元素的方法，而不用暴露集合内部的表示。
 * 常用场景为集合的遍历
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class IteratorDemo {
  
    public static void main(String[] args) {  
        Collection collection = new MyCollection();  
        Iterator it = collection.iterator();  
          
        while(it.hasNext()){  
            System.out.println(it.next());  
        }  
    }  
}  