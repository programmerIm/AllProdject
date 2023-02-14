package com.test.suanfa.threadDemo;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest
{
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,()->{
            System.out.println("可以围殴你");
        });

        for (int i = 1; i <= 7; i++) {
            final  int person = i;
            new Thread("thread"+person){
                @Override
                public void run() {
                    try {
                        System.out.println("拳手:"+person+"到了");
                        cyclicBarrier.await();
                    }catch (Exception e){

                    }
                }
            }.start();

        }
    }
}
