package com.bonc.springboot.demo;

import javafx.scene.paint.PhongMaterial;

/**
 * @auther :liming
 * @Description: 可重入锁
 * @Date: create in 2019/12/4 11:35
 */
class Phone{
    public  synchronized void sendEms(){
        System.out.println(Thread.currentThread().getId() +"\t invoid sendEms");
        sendEmail();
    }
    public  synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getId() +"\t invoid sendEmail");
    }
}
public class LockDemo2 {
    public static void main(String[] args) {
        final Phone phone = new Phone();
        new Thread(){
            @Override
            public void run() {
                phone.sendEms();
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                phone.sendEms();
            }
        }.start();
    }
}
