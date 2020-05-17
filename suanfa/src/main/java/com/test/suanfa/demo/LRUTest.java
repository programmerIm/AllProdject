package com.test.suanfa.demo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/5/9 14:31
 */
public class LRUTest<K, V> {
    private static final float factory = 0.75f;
    private LinkedHashMap<K, V> map;
    private int cacheSize;

    public LRUTest(int cacheSize) {
        this.cacheSize = cacheSize;
        int capacity = (int) (Math.ceil(cacheSize / factory) + 1);
        map = new LinkedHashMap<K, V>(capacity, factory, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUTest.this.cacheSize;
            }
        };
    }

    public synchronized void put(K key, V value) {
        map.put(key, value);
    }

    public synchronized V get(K key) {
        return map.get(key);
    }

    public void print() {
        for (Map.Entry<K, V> map : map.entrySet()) {
            System.out.print(map.getValue() + "--");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer arr[] = {4, 7, 0, 7, 1, 0, 1, 2, 1, 2, 6};
        LRUTest lru = new LRUTest(5);
        for (int i = 0; i < arr.length; i++) {
            lru.put(arr[i], arr[i]);
            lru.print();
        }
    }
}
