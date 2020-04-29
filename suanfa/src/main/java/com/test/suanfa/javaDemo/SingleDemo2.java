package com.test.suanfa.javaDemo;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/4/19 20:31
 */
public class SingleDemo2 {
    private static SingleDemo2 instance ;
    private SingleDemo2(){

    }
    public static synchronized SingleDemo2 getInstance(){
        if(instance==null){
            instance = new SingleDemo2();
        }
        return instance;
    }
    private static void print(){
        System.out.println("这是我自己的方法");
    }

    public static void main(String[] args) {
        SingleDemo2 singleDemo2=SingleDemo2.getInstance();
        singleDemo2.print();
    }
}
