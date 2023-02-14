package com.test.suanfa.javaDemo;

public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        ThreadOne threadOne = new ThreadOne();
        threadOne.start();

        Thread.sleep(3000);
      // threadOne.interrupt();

        System.out.println(threadOne.interrupted());


        // 阻塞main线程，让threadOne继续执行
        threadOne.join();
        System.out.println("main is run");
    }


}


class ThreadOne extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("sleep 20000 begin");
           Thread.sleep(2000*1000);
            System.out.println("sleep 20000 end");
        }catch (Exception e){
            System.out.println("threadOne is interrupted when sleeping");
        }
    }
}
