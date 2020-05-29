package com.test.suanfa.demo.TestClass;

/**
 * @auther :liming
 * @Description: 接口都是abstract;接口方法在1.8之后支持抽象方法，且必须要有方法体 ，接口方法默认都是public abstrarct的
 * @Date: create in 2020/5/26 23:20
 */
public   interface TestInterface {
    public abstract void testhee();
    default   void  testhhah(){

    }

}
