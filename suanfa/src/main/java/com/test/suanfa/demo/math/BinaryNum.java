package com.test.suanfa.demo.math;

/**
 * @auther :liming
 * @Description: 计算二进制数中1的个数
 * @Date: create in 2020/5/5 12:08
 */
public class BinaryNum {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(n+"的二进制数中1有:"+getBinaryNum(n));
    }
    public static  int getBinaryNum(int n ){
        int c = 0;
        while(n>0){
            if((n&1)==1){//当前位是1
                ++c; //计数器+1
            }
            n >>=1;//向右移位
        }
        return  c;
    }
}
