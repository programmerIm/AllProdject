package com.test.suanfa.test;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/4/29 22:54
 */
public class Father {
        public Father() {
            System.out.println("father 的构造器");
        }
        public static void showStatic(String string){
            System.out.println("father static"+string);
        }
        public final  void showFinal(){
            System.out.println("father final ");
        }
        public void showCommon(){
            System.out.println("father 普通方法");
        }
}
