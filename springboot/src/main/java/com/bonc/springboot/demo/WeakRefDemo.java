package com.bonc.springboot.demo;

import java.lang.ref.WeakReference;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2019/12/16 16:26
 */
public class WeakRefDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference weakReference = new WeakReference(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());
          o1 = null;
        System.gc();
        System.out.println("===========================");
        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}
