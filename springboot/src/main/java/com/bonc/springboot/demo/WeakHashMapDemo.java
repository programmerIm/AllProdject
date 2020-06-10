package com.bonc.springboot.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/16 16:46
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashMap();
        System.out.println("-----------------------");
        myWeakHashMap();
    }

    private static void myHashMap() {
        Map<Integer,Object> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "hashMap";
        map.put(key,value);
        System.out.println(map);
        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map);
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer,Object> map = new WeakHashMap<>();
        Integer key = new Integer(2);
        String value = "WeakHashMap";
        map.put(key,value);
        System.out.println(map);
        key = null;
        System.out.println(map);
        System.gc();
        System.out.println(map);
    }
}
