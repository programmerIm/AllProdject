package com.bonc.demo;

import java.util.concurrent.CountDownLatch;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/4 17:29
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(){
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"\t 走人");
                    countDownLatch.countDown();
                }
            }.start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t 关门");
    }
}
