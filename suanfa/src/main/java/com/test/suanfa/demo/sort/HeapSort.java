package com.test.suanfa.demo.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @auther :liming
 * @Description: 堆排序
 * @Date: create in 2020/6/17 11:55
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arry = {8, 5, 4, 9, 6}; //进行升序排序
        // arry.length/2 -1 是第一个非叶子节点
        for (int i = arry.length / 2 - 1; i >=0; i--) {
            ajustHeap(arry, i, arry.length);
        }
        //进行交换,将堆顶数据和数组最后一位交换
        int temp = 0;
        for (int j = arry.length - 1; j > 0; j--) {
            temp = arry[j];
            arry[j] = arry[0];
            arry[0] = temp;
            ajustHeap(arry, 0, j);
        }
        System.out.println(Arrays.toString(arry));
    }

    /**
     * @param arry   数组
     * @param i      非叶子节点
     * @param length 数组长度
     */
    public static void ajustHeap(int[] arry, int i, int length) {
        int temp = arry[i]; //保存当前非叶子节点的数据
        //k 为 i 节点的左子节点
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arry[k] < arry[k + 1]) {//说明右子节点大于左子节点
                k++; //将k指向右节点
            }
            if (temp < arry[k]) {//当右子节点大于父节点
                arry[i] = arry[k];//把较大节点赋给当前节点
                i = k;
            }else {
                break;//注意这里是从左到右，从上到下的
            }
        }
        arry[i] = temp;
    }
}
