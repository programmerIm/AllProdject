package com.bonc.springboot.service.Impl;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2019/2/26   11:17
 */
public class TestThreadServiceImpl {
    // --- 定义缓存区变量 ---
    protected BlockingQueue<Object> buffer = new LinkedBlockingQueue<Object>();

    //定义线程数
    int  iLocalThreadNum = 4;

    public void testThread(){

        ExecutorService threadPool  =  Executors.newFixedThreadPool(iLocalThreadNum);//创建线程池
          for(int i=1;i<=31;i++){
              threadPool.execute(new Runnable() {
                  @Override
                  public void run() {
                      System.out.println("去第一物理库执行sql");
                  }
              });
          }
    }


    public static void main(String args[]) {
        ExecutorService fixPool = Executors.newFixedThreadPool(4);
        String sql = "select min(Rec_id) from  xxx";
        for (int i = 1; i <= 4; i++) {  //模拟31个省，传递的值为省份id,
            fixPool.execute(getThread(i,sql));
        }
        fixPool.shutdown();
        System.out.println("最终的结果是:"+num.get());
    }

    private static  AtomicInteger num =new AtomicInteger(0); //线程安全的变量

    private static Runnable getThread(final int i,final  String sql) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("这一次要执行的sql:"+sql );
                    synchronized (num){ //针对当前类的变量上锁
                        num.addAndGet(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Thread id is "+Thread.currentThread().getId());
            }
        };
    }

   /* public static  void  printNum(Integer i){
        num.addAndGet(i);//相当于+ 的操作
    }*/
}
