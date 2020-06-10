package com.bonc.springboot.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/4 16:26
 */
class myCache {
    private volatile Map<String, String> map = new HashMap<>();
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void get(String key) {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在读取");
            Thread.sleep(300);
            String result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "\t 读取完成" + result);
        } catch (Exception e) {
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void set(String key) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t 正在写入" + key);
            map.put(key, key);
            System.out.println(Thread.currentThread().getName() + "\t 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}

public class WriteAndReadLock {
    public static void main(String[] args) {
        final myCache myCache = new myCache();
        for (int i = 0; i < 5; i++) {
            final  int tempInt  =  i;
            new Thread() {
                @Override
                public void run() {
                    myCache.set(tempInt+"");
                }
            }.start();
        }
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }

        for (int i = 0; i < 5; i++) {
            final  int tempInt  =  i;
            new Thread() {
                @Override
                public void run() {
                    myCache.get(tempInt+"");
                }
            }.start();
        }
    }
}
