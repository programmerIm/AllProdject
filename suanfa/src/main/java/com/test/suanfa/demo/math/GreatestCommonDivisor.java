package com.test.suanfa.demo.math;
import java.util.Scanner;
/**
 * @auther :liming
 * @Description: 最大公约数与最小公倍数问题
 *  最大公约数 用  更相减损法和辗转相除法
 *  最大公倍数  用 两个数相乘除以最大公约数
 * @Date: create in 2020/6/20 19:10
 */
public class GreatestCommonDivisor {
    /**
     *    求最大公约数有两种方法 更相减损法和辗转相处法 最小公倍数在求出最大公约数后 两个数相乘除以最大公约数就是最小公倍数
     *     以下我们用的是更相减损法
     *     更相减损法是拿两个数中的较大值减去较小值，然后在减数、被减数、差之间选取两个较小值继续相减，直到减数和被减数相等，得出的数就是最大公约数。
     *     例：
      */
 //更相减损术：
//8 10
//10 - 8=2
//8 - 2= 6
//6-2=4
//4-2=2
//2==2于是最大公约数就是2
    public  static  int getMax(int[] nums){
        int max = nums[0];
        int min = nums[0];
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
        }
        // 得到最大，最小的数
        int diff = 0;
        while(true){
            if(max == min){
                return max;
            }
            diff =  max - min;
            if(diff == min){
                break;
            }
            max = Math.max(diff,min);
            min = Math.min(diff,min);
        }
       return diff;
    }

 //辗转相除法  : a=25,b=15，a%b=10,b%10=5,10%5=0,最后一个为被除数余数的除数就是5,5就是所求最大公约数

    /**
     * 题目描述
     * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
     * 输入描述:
     * 输入两个正整数A和B。
     * 输出描述:
     * 输出A和B的最小公倍数。
     *
     * 示例1
     * 输入
     * 5 7
     * 输出
     * 35
     */
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int int1= scanner.nextInt();
            int int2= scanner.nextInt();
            System.out.println(int1*int2/methods(int1,int2));
        }

        // 求最大公约数--递归法
        public static int methods(int int1,int int2){
            if(int1 == int2){
                return int2;
            }
            if(int1 > int2){
                int differ= int1-int2;
                return methods(int2,differ);
            }else{
                int differ= int2-int1;
                return methods(int1,differ);
            }
        }
}
