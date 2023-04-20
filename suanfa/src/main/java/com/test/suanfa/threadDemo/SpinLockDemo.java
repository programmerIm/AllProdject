package com.test.suanfa.threadDemo;

import java.util.concurrent.atomic.AtomicReference;

public class SpinLockDemo {
    //初始引用类型肯定都是Null
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

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
        new Thread("线程1"){
            @Override
            public void run() {
                spinLockDemo.lock();
                try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
                spinLockDemo.unLock();
            }
        }.start();

        //保证线程1先执行
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        new Thread("线程2"){
            @Override
            public void run() {
                spinLockDemo.lock();
                spinLockDemo.unLock();
            }
        }.start();
    }
}
