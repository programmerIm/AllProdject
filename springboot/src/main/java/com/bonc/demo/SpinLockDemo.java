package com.bonc.demo;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/4 15:15
 */

public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();//初始引用类型肯定都是Null

    public void lock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t invoked lock");
        while (!atomicReference.compareAndSet(null,thread)){

        }
    }
    public void unLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t invoked unlock");
    }

    public static void main(String[] args) {
        final SpinLockDemo spinLockDemo = new SpinLockDemo();
         new Thread(){
             @Override
             public void run() {
                 spinLockDemo.lock();
                 try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
                 spinLockDemo.unLock();
             }
         }.start();

         //保证线程1先执行
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread(){
            @Override
            public void run() {
                spinLockDemo.lock();
                spinLockDemo.unLock();
            }
        }.start();
    }
}
