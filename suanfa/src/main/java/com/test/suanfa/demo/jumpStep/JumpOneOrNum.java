package com.test.suanfa.demo.jumpStep;

import java.util.Scanner;

/**
 * @auther :
 * @Description:  普通可以跳一阶，三阶  f(n)=f(n-1)+f(n-3)
 * @Date: create in 2020/6/20 21:26
 */
public class JumpOneOrNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int  all = scanner.nextInt();//台阶数
        if(all>50||all<0){
           return;
        }
        int   result = getMethodNum(all);
        System.out.println(result);
    }

    public static int getMethodNum(int all) {
        int  result = 0;
        if (all == 1) { //排除特殊数
            result =   1;
        } else if (all == 2) {
            result =   1;
        }else if(all==3){
            result = 2;
        }else {
            result =  getMethodNum(all - 1) + getMethodNum(all - 3);
        }
        return   result;
    }
}
