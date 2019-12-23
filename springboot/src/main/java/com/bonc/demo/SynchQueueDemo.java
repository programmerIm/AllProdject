package com.bonc.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/6 15:34
 */
public class SynchQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new SynchronousQueue();

        new Thread(()-> {
            try {
                System.out.println(Thread.currentThread().getName()+"put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"put 3");
                blockingQueue.put("3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"取出 "+blockingQueue.take());
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"取出 "+blockingQueue.take());
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName()+"取出 "+blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
