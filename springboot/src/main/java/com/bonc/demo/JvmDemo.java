package com.bonc.demo;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/11/29 17:00
 */
class MyData{
    /**
     * volatile  保证可见性
     */
    public  int number = 0;
    public void addNumber60(){
        this.number = 60;
    }
}

public class JvmDemo {
    public static void main(String[] args) {
       final MyData data = new MyData();
        new Thread(){
            @Override
            public void run() {
                System.out.println("当前线程的"+Thread.currentThread().getName()+"---number:"+data.number);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                data.addNumber60();
                System.out.println("当前线程的"+Thread.currentThread().getName()+"--number:"+data.number);
            }
        }.start();

        while (data.number==0){
        }
        System.out.println("这里是main线程得到的number"+data.number);
    }
}
