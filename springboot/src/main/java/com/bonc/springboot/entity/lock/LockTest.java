package com.bonc.springboot.entity.lock;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/5/11 21:37
 */
public class LockTest {
    public static void main(String[] args) {
        //模拟多个10个客户端
        for (int i=0;i<10;i++) {
            Thread thread = new Thread(new LockRunnable());
            thread.start();
        }

    }

    static class LockRunnable implements Runnable{
        @Override
        public void run() {
            ZookeeperDistrbuteLock zkLock = new ZookeeperDistrbuteLock();
            //ZookeeperHighLock  zkLock = new ZookeeperHighLock();//高性能锁
            zkLock.getLock();
            //模拟业务操作
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            zkLock.unLock();
        }
    }
}
