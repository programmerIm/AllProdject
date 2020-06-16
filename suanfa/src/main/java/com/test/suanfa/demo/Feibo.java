package com.test.suanfa.demo;

import java.util.Scanner;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/6/16 23:49
 */
public class Feibo {
    //斐波那契数列，利用一维数组
    public static void main(String[] args) {
        System.out.println("请输入要输出的数列项数：");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if (a == 1) {
            System.out.println(1);
            return;
        }
        int[] arr = new int[a];
        arr[0] = arr[1] = 1;
        System.out.print(arr[0] + "\t" + arr[1] + "\t");
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            System.out.print(arr[i] + "\t");
        }
    }
}
