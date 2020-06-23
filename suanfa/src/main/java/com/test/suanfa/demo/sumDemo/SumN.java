package com.test.suanfa.demo.sumDemo;

/**
 * @auther :liming
 * @Description: 求和 1+ 2+3+.....n  (要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。)
 * @Date: create in 2020/6/18 19:28
 */
public class SumN {
    public static int Sum_Solution(int n) {
     int result =0;
     int end =1 ;
     boolean flag = (n!=0)&& end ==(result = Sum_Solution(n-1));
     result += n;
     return  result;
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution(3));
    }
}
