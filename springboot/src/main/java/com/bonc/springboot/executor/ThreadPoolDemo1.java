package com.bonc.springboot.executor;

/**
 * @auther :liming
 * @Description: 如何设置合理的线程数
 * @Date: create in 2019/12/11 10:24
 */
public class ThreadPoolDemo1 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());//获取当前cpu的核数
    }
}
