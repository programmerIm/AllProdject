package com.bonc.springboot.service.Impl;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:liming
 * @Description: 多线程 执行update sql 统计更新条数，模拟
 * @Date:create in 2019/2/26   11:17
 */
public class TestThreadServiceImpl {
    // --- 定义缓存区变量 ---
    protected BlockingQueue<Object> buffer = new LinkedBlockingQueue<Object>();

    //定义线程数
   private int  iLocalThreadNum = 4;

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

   private static CountDownLatch count;//计数器
   private static  AtomicInteger num =new AtomicInteger(0); //线程安全的变量

    public static void main(String args[]) {
        ExecutorService fixPool = Executors.newFixedThreadPool(4);
        count = new CountDownLatch(4);
        String sql = "select min(Rec_id) from  xxx";
        for (int i = 1; i <= 7; i++) {  //模拟31个省，传递的值为省份id,
            fixPool.execute(getThread(i,sql));
        }
        try {
            count.await();//等待所有线程跑完
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fixPool.shutdown(); //关闭线程资源
        System.out.println("最终的结果是:"+num.get());//输出最终结果
    }

    private static Runnable getThread(final int i,final  String sql) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("这一次要执行的sql:"+sql );
                        num.addAndGet(i);
                    System.out.println("Thread id is "+Thread.currentThread().getId());
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    count.countDown();
                }
            }
        };
    }
}
