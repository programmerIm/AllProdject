package com.bonc.springboot.test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/2/26 22:22
 */

public class ThreadPoolTool<T> {

    //单个线程处理的数据量
    private int singleCount;
    //处理的总数据量
    private int listSize;
    //开启的线程数
    private int runSize;
    //操作的数据集
    private List<T> list;
    //计数器
    private CountDownLatch begin,end;
    //线程池
    private ExecutorService executorService;
    //回调
    private CallBack callBack;

    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }

    public ThreadPoolTool(int singleCount, List<T> list){
        this.singleCount = singleCount; //单次处理的数据量
        this.list = list;
        if (list != null){
            this.listSize = list.size();
            this.runSize = (this.listSize/this.singleCount) + 1;//开启的线程数
        }
    }

    public void excute() throws InterruptedException {
        executorService = Executors.newFixedThreadPool(runSize);
        begin = new CountDownLatch(1);
        end = new CountDownLatch(runSize);
        //创建线程
        int startIndex = 0;
        int endIndex = 0;
        List<T> newList = null;
        for (int i = 0; i < runSize; i++) {
            //计算每个线程对应的数据
            if (i < (runSize - 1)){
                startIndex = i * singleCount;
                endIndex = (i + 1) * singleCount;
                newList = list.subList(startIndex,endIndex);
            }else { //最后一批
                startIndex = i * singleCount;
                endIndex = listSize;
                newList = list.subList(startIndex,endIndex);
            }
            //创建线程类处理数据
            MyThread<T> myThread = new MyThread(newList, begin, end) {
                @Override
                public void method(List list) {
                    callBack.method(list);
                }
            };
            //执行线程
            executorService.execute(myThread);
        }
        //计数器减一
        begin.countDown();
        end.await();
        //关闭线程池
        executorService.shutdown();
    }

    //抽象线程类
    public abstract class MyThread<T> implements Runnable{

        private List<T> list;
        private CountDownLatch begin,end;

        public MyThread(List<T> list, CountDownLatch begin, CountDownLatch end){
            this.list = list;
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            try {
                //执行程序
                method(list);
                begin.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                //计数器减一
                end.countDown();
            }
        }
        public abstract void method(List<T> list); //线程类实现了接口
    }

    //回调接口定义
    public interface CallBack<T>{
        public void method(List<T> list);
    }


    public static void main(String[] agrs){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add("hello"+i);
        }
        ThreadPoolTool<String> tool = new ThreadPoolTool(1000,list);
        tool.setCallBack(new CallBack<String>() {
            @Override
            public void method(List<String> list) { //实现了method方法
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(Thread.currentThread().getId()+":"+list.get(i)+" ");
                }
                System.out.println();
            }
        });
        try {
            tool.excute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

