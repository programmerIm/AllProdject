package com.bonc.springboot.demo;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/9 11:45
 */

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A 打印5 次，  B 打印10次，C打印15次
 *
 * 循环10次
 */
class ResourceDemo{
    private int number = 1 ; //A :1 B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5(){
        lock.lock();
        try {
           while (number!=1){
               c1.await();
           }
            for (int i = 0; i < 5 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t " +i);
            }
            number = 2;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.lock();
        }
    }

    public  void print10(){
        lock.lock();
        try {
            while (number!=2){
                c2.await();
            }
            for (int i = 0; i < 10 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t " +i);
            }
            number = 3;
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.lock();
        }
    }

    public void print15(){
        lock.lock();
        try {
            while (number!=3){
                c3.await();
            }
            for (int i = 0; i < 15 ; i++) {
                System.out.println(Thread.currentThread().getName()+"\t " +i);
            }
            number = 1;
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.lock();
        }
    }
}

public class ConditionDemo {
    public static void main(String[] args) {
        ResourceDemo  resourceDemo = new ResourceDemo();
        new Thread (()->{
            for (int i = 0; i <10 ; i++) {
                resourceDemo.print5();
             }
        }).start();
        new Thread (()->{
            for (int i = 0; i < 10 ; i++) {
                resourceDemo.print10();
            }
        }).start();
        new Thread (()->{
            for (int i = 0; i < 10 ; i++) {
                resourceDemo.print15();
            }
        }).start();
    }
}
