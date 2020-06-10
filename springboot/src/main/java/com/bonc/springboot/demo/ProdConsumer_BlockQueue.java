package com.bonc.springboot.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/9 15:13
 */
class MyResource{
    private volatile   boolean Flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger();
    private BlockingQueue<String>  blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public  void myProd() throws Exception{
        String data = null;
        boolean result;
        while (Flag){
            data  = atomicInteger.incrementAndGet() + "";
            result = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if(result){
                System.out.println(Thread.currentThread().getName()+"\t 生产者插入数据"+data+"成功");
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 生产者插入数据"+data+"失败");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("停止生产，Flag = false");
    }

    public void stop()  throws Exception{
        this.Flag = false;
    }

    public void constomer() throws Exception{
        String data = null;
        while (Flag){
            data = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if(data ==null ||data.equalsIgnoreCase("")){
                Flag = false;
                System.out.println(Thread.currentThread().getName()+"\t 超过两秒没有获取数据,消费退出");
                return;
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 消费者取出数据"+data+"成功");
            }
        }
    }
}
public class ProdConsumer_BlockQueue {
    public static void main(String[] args) throws Exception{
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(()-> {
            try{
                myResource.myProd();
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try{
                myResource.constomer();
            }catch (Exception e){
                e.printStackTrace();
            }
        }).start();

        TimeUnit.SECONDS.sleep(5);
        System.out.println("5秒后主线程叫停,停止操作");
        myResource.stop();
    }
}
