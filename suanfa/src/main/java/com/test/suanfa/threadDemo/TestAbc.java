package com.test.suanfa.threadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestAbc {
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
                number = 2;
                for (int i = 0; i < 5 ; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t " +"A");
                }
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
                number = 3;
                for (int i = 0; i < 10 ; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t " +"B");
                }
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
                number = 1;
                for (int i = 0; i < 15 ; i++) {
                    System.out.println(Thread.currentThread().getName()+"\t " +"C");
                }
                c1.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.lock();
            }
        }


        public static void main(String[] args) {
            TestAbc  resourceDemo = new TestAbc();
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
