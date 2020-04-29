package com.test.suanfa.javaDemo;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/4/20 23:14
 */
public class FrogJump {
    public static int jump(int number){
        if(number<=0){
            return  1;//不跳
        }
        int sum = 0;
        if(number>1){
            //i 代表当前跳的层数,下一次剩余最大跳的是nubmer-1，每次是1 循环次数最多number-1次
            for(int i=1;i<=number-1;i++){
                sum = sum +  jump(number - i);
            }
        }
        return  sum +1;
    }

    public static void main(String[] args) {
        int method = jump(2);
        System.out.println("一共有多少种跳法"+method);
        int method2 = jump2(5);
        System.out.println("一共有多少种跳法"+method2);
        int method3 = jump3(5);
        System.out.println("一共有多少种跳法"+method3);
    }
    static  int jump2(int number){
        return  1<<--number;
    }
    static  int jump3(int number){
        return (int) Math.pow(2, number-1);
    }
}
