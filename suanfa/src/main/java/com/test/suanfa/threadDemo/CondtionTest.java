package com.test.suanfa.threadDemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CondtionTest {

    private  Integer number = 0;

    private Integer printNum = 1;

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {
        CondtionTest condtionTest = new CondtionTest();

/*        new Thread("生产者"){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    condtionTest.producer();
                }
            }
        }.start();

        new Thread("消费者"){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    condtionTest.consumer();
                }
            }
        }.start();*/


/*        new Thread("奇数打印者"){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    condtionTest.printOne();
                }
            }
        }.start();

        new Thread("偶数打印者"){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    condtionTest.printTwo();
                }
            }
        }.start();*/



        new Thread("字符打印"){
            @Override
            public void run() {
                String[] strings = {"A","B","C","D","F"};
                for (int i = 0; i < strings.length; i++) {
                    condtionTest.printString(strings[i]);
                }
            }
        }.start();


        new Thread("数字打印"){
            @Override
            public void run() {
                for (int i = 1; i <= 5; i++) {
                    condtionTest.printNumber(i);
                }
            }
        }.start();

    }


    public void producer(){
        lock.lock();
        try {
            while (number!=0){
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"生产了"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void consumer(){
        lock.lock();
        try {
            while (number==0){
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"消费了"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printOne(){
        lock.lock();
        try {
            // 是偶数就等待
            while (printNum%2==0){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+"打印"+printNum);
            printNum++;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printTwo(){
        lock.lock();
        try {
            //
            while (printNum%2!=0){
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+"打印"+printNum);
            printNum++;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printNumber(int number){
        lock.lock();
        try {
            // 是偶数就等待
            while (printNum%2==0){
                condition.await();
            }
            System.out.print(number);
            printNum++;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printString(String string){
        lock.lock();
        try {
            // 奇数等待
            while (printNum%2!=0){
                condition.await();
            }
            System.out.print(string);
            printNum++;
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
