package com.bonc.demo;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/11 11:17
 */
class MySource implements  Runnable{
    private String lockA;
    private String lockB;

    public MySource(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"\t自己持有"+lockA +"尝试获取"+lockB);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"\t自己持有"+ lockB +"尝试获取"+lockA);
            }
        }
    }
}
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new MySource(lockA,lockB)).start();
        new Thread(new MySource(lockB,lockA)).start();
    }
}
