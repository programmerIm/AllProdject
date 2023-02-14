package com.test.suanfa.threadDemo;


import java.util.concurrent.atomic.AtomicStampedReference;

public class AbaDemo3 {
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<Integer>(100,1);
    public static void main(String[] args) {
        System.out.println("-----------ABA问题的解决-----------");
        new Thread("thread3"){  //线程3
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

        new Thread("thread4"){  //线程4
            @Override
            public void run() {
                int stamp = atomicStampedReference.getStamp();
                System.out.println(Thread.currentThread().getName()+"\t第一次获取的时间戳为"+stamp);
                //休息三秒中,保证线程A执行一次ABA
                try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
                System.out.println(Thread.currentThread().getName()+"\t更新"+atomicStampedReference.compareAndSet(100,2019,stamp,stamp+1));
                System.out.println(Thread.currentThread().getName()+"\t此时的值为"+atomicStampedReference.getReference());
            }
        }.start();
    }

}
