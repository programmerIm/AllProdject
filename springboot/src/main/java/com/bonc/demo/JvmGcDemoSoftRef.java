package com.bonc.demo;

import java.lang.ref.SoftReference;

/**
 * @auther :liming
 * @Description: 验证
 * @Date: create in 2019/12/12 15:49
 */
public class JvmGcDemoSoftRef {
    public static  void enoughSoftRef(){ //内存足够的
        Object b1 = new Object();
        SoftReference b2 = new SoftReference(b1);
        System.out.println(b1);
        System.out.println(b2.get());
        b1 = null;
        System.gc();
        System.out.println("垃圾回收完的结果");
        System.out.println(b1);
        System.out.println(b2.get());
    }

    /**
     * 需要将 初始内存 设置为 5M
     */
    public static  void NoEnoughSoftRef(){
        Object b1 = new Object();
        SoftReference b2 = new SoftReference(b1);
        System.out.println(b1);
        System.out.println(b2.get());
        try {
          byte[] bytes = new byte[20*1024*1024];
        }catch (Exception e){
             e.printStackTrace();
        }finally {
            System.out.println(b1);
            System.out.println(b2.get());
        }
    }

    public static void main(String[] args) {
        enoughSoftRef();
       // NoEnoughSoftRef();
    }
}
