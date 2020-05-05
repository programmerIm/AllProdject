package com.test.suanfa.demo.sort;

import java.util.Arrays;

/**
 * @auther :liming
 * @Description: 希尔排序-将数组一次次分组，进行插入排序
 * @Date: create in 2020/4/29 15:33
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arry = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        sort2(arry);
        System.out.println(Arrays.toString(arry));
    }

    //普通版
    private static void sort(int[] arry) {
        int temp = 0;
        for (int grap = arry.length / 2; grap > 0; grap /= 2) {  //将数组进行分组；grap 步长
            for (int i = grap; i < arry.length; i++) {       //处理每组数据
                for (int j = i - grap; j >= 0; j -= grap) {     //在每组数据中使用插入排序
                    if (arry[j] > arry[j + grap]) {
                        temp = arry[j];
                        arry[j] = arry[j + grap];
                        arry[j + grap] = temp;
                    }
                }
            }
        }
    }

    //升级版的希尔排序
    public static void sort2(int[] array) {
        for (int grap = array.length / 2; grap > 0; grap /= 2) {  //将数组进行分组；grap 步长
            for (int i = grap; i < array.length; i++) {//从步长位置开始，逐个对其所在数组进行直接插入排序
                int j = i;//需要待插入位置的索引
                int temp = array[j]; //临时变量存储该位置的数据
                if (array[j] < array[j - grap]) {
                    while (j - grap >= 0 && temp < array[j - grap]) {
                        array[j] = array[j - grap];
                        j -= grap;
                    }
                    //跳出循环时指的是 此时j就是需要移动的位置
                    array[j] = temp;
                }
            }
        }
    }
}
