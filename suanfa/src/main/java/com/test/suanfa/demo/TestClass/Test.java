package com.test.suanfa.demo.TestClass;

/**
 * @auther :liming
 * @Description: 执行顺序
 * @Date: create in 2020/5/20 17:59
 */
public class Test {
        public static int a = 0;
        static {// Step 1
            a = 8;
            System.out.println("静态代码块在执行a=" + a);
        }
    public Test() {
        this("调用无参构造方法1，a=" + a); // Step 2
        System.out.println("无参构造方法在执行a=" + a);// Step 7
    }
       public Test(String n) {
            this(n, "调用带参构造方法2，a=" + a); // Step 3
            System.out.println("带参构造方法1在执行a=" + a); // Step 6
        }
        public Test(String s1, String s2) {
            System.out.println(s1 + "；" + s2);// Step 5
        }
        {// Step 4
            a = 10;
            System.out.println("非静态代码块（构造代码块）在执行a=" + a);
        }
        public static void main(String[] args) {
            Test t = null;// JVM加载Test类，静态代码块执行
            System.out.println("下面new一个Test实例：在没new对象之前执行");
            t = new Test();
        }
}
