package com.bonc.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/3 11:26
 */
public class AbaDemo2 {
    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(100,1);

    public static void main(String[] args) {
        System.out.println("-------ABA问题的产生----------");
        new Thread(){  //线程1
            @Override
            public void run() {
                atomicReference.compareAndSet(100,101);
                atomicReference.compareAndSet(101,100);
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                //线程2，休息一秒中，保证线程1完成了一次ABA操作
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+":"+atomicReference.compareAndSet(100,2019)+"此时的值为"+atomicReference.get());
            }
        }.start();

        try { Thread.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("-----------ABA问题的解决-----------");

        new Thread(){  //线程3
            @Override
            public void run() {
              int stamp = atomicStampedReference.getStamp();
                System.out.println(Thread.currentThread().getName()+"\t第一次时间戳为"+stamp);
                //暂停一秒，保证t4拿到一样的版本号
                try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
                atomicStampedReference.compareAndSet(100,101,stamp,stamp+1);
                System.out.println(Thread.currentThread().getName()+"\t第2次时间戳为"+atomicStampedReference.getStamp());
                atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
                System.out.println(Thread.currentThread().getName()+"\t第3次时间戳为"+atomicStampedReference.getStamp());
            }
        }.start();

        new Thread(){  //线程4
            @Override
            public void run() {
                int stamp = atomicStampedReference.getStamp();
                System.out.println(Thread.currentThread().getName()+"\t第一次获取的时间戳为"+stamp);
                //休息三秒中
                try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+"\t更新"+atomicStampedReference.compareAndSet(100,2019,stamp,stamp+1));
                System.out.println(Thread.currentThread().getName()+"\t此时的值为"+atomicStampedReference.getReference());
            }
        }.start();

        Map map = new ConcurrentHashMap();
    }
}
