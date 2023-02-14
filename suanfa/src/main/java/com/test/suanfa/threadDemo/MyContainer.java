package com.test.suanfa.threadDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.LockSupport;

public class MyContainer {

    // 统计数量
    private volatile int limit = 0;
    private int total = 0;
    private BlockingQueue<Integer> queue;

    public MyContainer(int total) {
        this.queue = new ArrayBlockingQueue<>(total);
        this.total = total;

    }

    public boolean add(Integer value) {
        if (limit < total) {
            queue.add(value);
            limit++;
            System.out.println("添加数据");
            return true;
        }
        return false;
    }

    public int size() {
        return limit;
    }

    static Thread t1, t2 = null;

    public static void main(String[] args) throws InterruptedException {
        MyContainer myContainer = new MyContainer(10);

        t1 = new Thread("线程1") {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        // 每次都添加
                        myContainer.add(1);
                        if (myContainer.size() == 5) {
                            // 通知提示
                            LockSupport.unpark(t2);
                            LockSupport.park();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };


        t2 = new Thread("线程2") {
            @Override
            public void run() {
                try {
                    // 上来就阻塞，等待给出提示
                    LockSupport.park();
                    System.out.println("当前已够" + 5 + "个，退出");
                    LockSupport.unpark(t1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        // 先启动监控，阻塞
        t2.start();
        Thread.sleep(1000);
        t1.start();
    }
}
