package com.demo.java.apachecommons.collections;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;

/**
 * @author SUNHAN
 * @Date: 2014年9月29日
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("unchecked")
public class SimpleHashMap<K, V> {
     
    private static final int ARRAY_SiZE = 997;
    private LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[ARRAY_SiZE];
    public V put(K key, V value) {  //添加一个键值对
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % ARRAY_SiZE; //通过哈希码取绝对值再取模操作得到key的索引值
        if(buckets[index] == null) {
            buckets[index] = new LinkedList<MapEntry<K, V>>();
        }
        LinkedList bucket = buckets[index];
        MapEntry newEntry = new MapEntry<K, V>(key, value);
        ListIterator<MapEntry<K, V>> itr = bucket.listIterator();
        while(itr.hasNext()) {  //遍历，是否key已存在
            MapEntry<K, V> entry = itr.next();
            if(entry.getKey().equals(key)) {    //存在
                oldValue = entry.getValue();
                itr.set(newEntry);  //将新值覆盖旧值
                return oldValue;
            }
        }
        bucket.add(newEntry);//添加新键值对
        return oldValue;
    }
     
    public V get(Object key) {  //通过key得到value
        int index = Math.abs(key.hashCode()) % ARRAY_SiZE;  //通过哈希码取绝对值再取模操作得到key的索引值
        if(buckets[index] == null) {
            return null;
        }
        for(MapEntry<K ,V> entry : buckets[index]) {
            if(entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }
     
    public Set<MapEntry<K, V>> entrySet() { //返回一个set
        Set<MapEntry<K, V>> set = new HashSet<MapEntry<K, V>>();
        for(LinkedList<MapEntry<K, V>> bucket : buckets) {  //遍历数组以及LinkedList，将所有存在的键值对放进set中返回
            if(bucket == null) continue;
            for(MapEntry<K, V> entry : bucket) {
                set.add(entry);
            }
        }
        return set;
    }
     
    public V remove(Object key) {   //移除指定的键值对，并返回value
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % ARRAY_SiZE;
        if(buckets[index] == null) {
            return null;
        }
        for(MapEntry<K, V> entry : buckets[index]) {
            if(entry.getKey().equals(key)) {
                oldValue = entry.getValue();
                buckets[index].remove(entry);
                return oldValue;
            }
        }
        return oldValue;
    }
     
    public void clear() {   //清除整个map
        for(int i = 0; i < buckets.length; i++) {
            if(buckets[i] != null) {
                buckets[i] = null;
            }
        }
    }
     
    static class MapEntry<K, V>{
        K key;
        V value;
        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
 
        public K getKey() {
            return key;
        }
 
        public V getValue() {
            return value;
        }
 
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
 
        @Override
        public int hashCode() {
            return key == null ? 0 : key.hashCode()
                    ^ (value == null ? 0 : value.hashCode());
        }
 
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof MapEntry)) {
                return false;
            }
            MapEntry<K, V> me = (MapEntry<K, V>) o;
            return (key == null ? me.getKey() == null : key.equals(me.getKey()))
                    && (value == null ? me.getValue() == null : value.equals(me
                            .getValue()));
        }
 
        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}