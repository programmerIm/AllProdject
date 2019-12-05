package com.test.suanfa.javaDemo;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/9/5 10:30
 */
class MyData{
    int number =0;
    public void add60(){
        this.number = 60;
    }
}

/**
 * 验证volatile可见性
 */
//1.1没有给numbser添加volatile可见性
public class VolatileDemo {
    public static void main(String[] args) {
         MyData myData = new MyData();

         Thread thread = new Thread("AAA");
         thread.start();
    }
}
