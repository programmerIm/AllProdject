package com.bonc.demo;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @auther :liming
 * @Description: 虚引用和引用队列一起使用  ，回收前先放进队列中
 * @Date: create in 2019/12/16 17:42
 */
public class PhantomRefDemo {
    public static void main(String[] args) throws InterruptedException {
        Object o1= new Object();
        ReferenceQueue referenceQueue = new ReferenceQueue();
        WeakReference<Object> weakReference = new WeakReference<>(o1,referenceQueue);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

        System.out.println("--------------------");
        o1 =null;
        System.gc();
        Thread.sleep(500);
        System.out.println(o1);
        System.out.println(weakReference.get());
        System.out.println(referenceQueue.poll());

    }
}
