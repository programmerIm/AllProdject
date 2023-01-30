package com.jd.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author: liming522
 * @description:
 * @date: 2022/11/17 2:46 PM
 * @hope: The newly created file will not have a bug
 */
public class Test3 {

    public static void main(String[] args) {
        //dropWhileTest();
        //takeWhileTest();
        iterateTest();
    }

    public static void dropWhileTest(){
        List<Integer> strings = Arrays.asList(3,3,3,2, 2, 3);
        // 从头开始删所有的奇数，直到遇到第一个偶数
        strings.stream().dropWhile(s -> s%2==1).forEach(System.out::println);
    }

    public static  void takeWhileTest(){
        List<Integer> strings = Arrays.asList(3,3,3,2, 2, 3);
        // 从头开始取所有的奇数，直到遇到第一个偶数
        strings.stream().takeWhile(s -> s%2==1).forEach(System.out::println);
    }


    public static  void  iterateTest(){
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        // 从0开始，取10个数
       // Stream.iterate(0, i -> i + 2).limit(10).forEach(System.out::println);

        // 从0 开始,取10个数，每次加2
        Stream.iterate(0, i -> i < 16, i -> i + 2).limit(5).forEach(System.out::println);
    }

}
