package com.bonc.springboot.executor;

import org.apache.tomcat.util.threads.TaskThreadFactory;

import java.util.concurrent.*;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/11 9:59
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executor  = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 0; i < 10; i++) {
                executor.execute(()-> System.out.println(Thread.currentThread().getName()+"执行完成"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            executor.shutdown();
        }
    }
}
