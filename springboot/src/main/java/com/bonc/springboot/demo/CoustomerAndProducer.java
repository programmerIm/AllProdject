package com.bonc.springboot.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/9 10:15
 */
class  SingData{
    private int  number =  0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //生产
    public void  adddNumber(){
        lock.lock();
        try {
            while (number!=0){
                //等待不能,生产
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName()+"\t 此时number的值为"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void  delNumber(){
        lock.lock();
        try {
            while (number==0){
                //等待，不进行消费
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName()+"\t 此时number的值为"+number);
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

public class CoustomerAndProducer {
    public static void main(String[] args) {
        SingData  singData = new SingData();
       /*     new Thread(()-> {
            for (int i = 0; i < 5; i++){
                    singData.adddNumber();
             }
        }).start();

         new Thread(()-> {
                for (int i = 0; i < 5; i++) {
                    singData.delNumber();
                }

         }).start();*/
  }
}
