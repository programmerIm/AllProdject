package com.test.suanfa.demo;

import java.util.Scanner;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/6/16 23:51
 */
public class Feibo2 {
    //使用递归方法
    private static int getFibo(int i) {
        if (i == 1 || i == 2){
            return 1;
        }else{
            return getFibo(i - 1) + getFibo(i - 2);
        }
    }
    public static void main(String[] args) {
        System.out.println("请输入要输出的项数：");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        System.out.println("斐波那契数列的前"+a+"项为：");
        for (int j = 1; j <= a; j++) {
            System.out.print(getFibo(j) + "\t");
        }
    }
}
