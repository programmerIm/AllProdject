package com.bonc.springboot.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/2 17:09
 */
public class CasDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,2019)+"\t current value"+atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,1024)+"\t current value"+atomicInteger.get());
    }
}
