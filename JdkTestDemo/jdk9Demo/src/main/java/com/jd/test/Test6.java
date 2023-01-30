package com.jd.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: liming522
 * @description:
 * @date: 2022/11/17 3:55 PM
 * @hope: The newly created file will not have a bug
 */
public class Test6 {
    public static void main(String[] args) {
        // java 8以前创建不可变集合
       List<String> list2 = new ArrayList<>();
       list2.add("1");
       list2.add("2");
       list2.add("3");
       List<String> strings = Collections.unmodifiableList(list2);
       strings.add("4");

       // java9创建不可变集合
       /*  List<String> list = List.of("a","b","c");
       list.add("d"); */
    }
}
