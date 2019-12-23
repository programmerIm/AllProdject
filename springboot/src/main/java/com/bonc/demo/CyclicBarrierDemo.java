package com.bonc.demo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/5 17:46
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()-> System.out.println("**********可以召唤神龙"));

        for (int i = 0; i < 7; i++) {
            final   int x = i;
            new Thread(() -> {
                System.out.println("集齐了第"+x+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
