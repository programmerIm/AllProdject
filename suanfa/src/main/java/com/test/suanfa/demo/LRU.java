package com.test.suanfa.demo;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther :liming
 * @Description:最久未使用
 * @Date: create in 2020/5/5 1:21
 */
public class LRU<K,V> {
    private static final float hashLoadFactory = 0.75f;
    private LinkedHashMap<K,V> map;
    private int cacheSize;

    public LRU(int cacheSize) {
        this.cacheSize = cacheSize;
        int capacity = (int)Math.ceil(cacheSize / hashLoadFactory) + 1;
        map = new LinkedHashMap<K,V>(capacity, hashLoadFactory, true){
            private static final long serialVersionUID = 1;
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > LRU.this.cacheSize;
            }
        };
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized void clear() {
        map.clear();
    }

    public synchronized int usedSize() {
        return map.size();
    }

    public void print() {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.print(entry.getValue() + "--");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer  arr[] = {4,7,0,7,1,0,1,2,1,2,6};
        LRU lru = new LRU(5);
        for(int i=0; i<arr.length; i++) {
            lru.put(arr[i],arr[i]);
            lru.print();
        }
    }
}
