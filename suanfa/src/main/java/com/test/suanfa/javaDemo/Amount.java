package com.test.suanfa.javaDemo;

import java.util.concurrent.TimeUnit;


/**
 * 同步和非同步方法一起执行导致脏读
 * @author liming522
 * @date 2023/2/9 23:15
 * @param null
 * @return null
 */
public class Amount {
        String name;
        double balance;

        public synchronized void set(String name, double balance) {
            this.name = name;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.balance = balance;
        }

        public /*synchronized*/ double getBalance(String name) {
            return this.balance;
        }

        public static void main(String[] args) {
            Amount a = new Amount();
            new Thread(()->a.set("zhangsan", 100.0)).start();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(a.getBalance("zhangsan"));

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(a.getBalance("zhangsan"));
        }
}
