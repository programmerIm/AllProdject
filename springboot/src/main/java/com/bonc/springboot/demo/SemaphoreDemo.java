package com.bonc.springboot.demo;

import java.util.concurrent.Semaphore;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/6 10:07
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 6; i++) {
            final  int number = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+number+"\t 抢到了资源");
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+number+"\t 释放资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                     semaphore.release();
                }
            }).start();
        }
    }
}
