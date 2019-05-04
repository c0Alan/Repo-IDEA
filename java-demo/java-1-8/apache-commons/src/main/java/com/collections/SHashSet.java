package com.collections;

import java.util.HashMap;

public class SHashSet {
    
    HashMap map;
    private static final Object PRERSENT=new Object();
    
    int size;
    
    public int size(){
        return map.size();
    }
    public SHashSet(){
        map=new HashMap();
    }
    
    public void add(Object o){
        map.put(0, PRERSENT);
    }
    
    public static void main(String[] args) {
        
    }
}