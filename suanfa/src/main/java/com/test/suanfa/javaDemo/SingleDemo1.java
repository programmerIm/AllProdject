package com.test.suanfa.javaDemo;

/**
 * @auther :liming
 * @Description:单例模式 饿汉  提前创建，用的时候有现成的
 * @Date: create in 2020/4/19 20:26
 */
public class SingleDemo1 {
    private SingleDemo1(){
    }
    private static  SingleDemo1 instance  = new SingleDemo1();
    public static   SingleDemo1 getInstance(){
        return instance;
    }
    private void  print(){
        System.out.println("这是我自己的方法");
    }

    public static void main(String[] args) {
        SingleDemo1 singleDemo1 = SingleDemo1.getInstance();
        singleDemo1.print();
    }
}
