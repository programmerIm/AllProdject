package com.test.suanfa.demo.sort;

import java.util.Arrays;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/5/16 16:03
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arry = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81};
        radixSort(arry);
        System.out.println(Arrays.toString(arry));
    }

    private static void radixSort(int[] arry) {
        //1.先求出数组的最大位数
        int maxValue = 0;
        for (int i = 0; i < arry.length; i++) {
            if (arry[i] > maxValue) {
                maxValue = arry[i];
            }
        }

        //2.按位数进行分桶存放
        for (int k = 1; k <= maxValue; k *= 10) {  //k代表位数  1 是10位  2 是百位
            int[] buckets = new int[10]; //按位数创建的桶
            int[] outPut  = new int[arry.length];
            //统计不同位数在出现的次数
            for (int j = 0; j < arry.length; j++) {
                int bucket = (arry[j] / k) % 10;
                buckets[bucket] += 1;//按位数计数，位数出现次数，对应数组索引位置+1
            }

            // 3.更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
            for (int i = 1; i < 10; i++) {
                buckets[i] += buckets[i - 1];//比如将元素个数累加,buckets[i]是当前桶最后一个数该放的位置
            }

            // 4.将数据存储到临时数组output[]中
            for (int i = 0; i <arry.length ; i++) {
                outPut[buckets[(arry[i] / k) % 10] - 1] = arry[i];//倒序存放，将每个桶中数据一依次从上一步骤该放位置依次往前填充
                buckets[(arry[i] / k) % 10]--;//将计数位置减一，代表该放置了一个
            }

            //5.经过一次排序后的大桶
            for (int i = 0; i < arry.length; i++) {
                arry[i] = outPut[i];
            }
        }
    }
}
