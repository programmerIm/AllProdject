package com.bonc.springboot.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/4 11:53
 */
class Phones implements  Runnable{
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        set();
    }

    public  void set(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+"\t invock set");
            get();
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }
    public  void get(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId()+"\t invock get");
        }catch (Exception e){
        }finally {
            lock.unlock();
        }
    }
}

public class LockDemo3 {
    public static void main(String[] args) {
        Phones phones1 = new Phones();
        Phones phones2 = new Phones();

        Thread thread1  = new Thread(phones1);
        Thread thread2  = new Thread(phones2);
        thread1.start();
        thread2.start();
    }
}
