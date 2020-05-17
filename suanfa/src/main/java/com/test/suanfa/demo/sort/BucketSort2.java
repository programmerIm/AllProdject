package com.test.suanfa.demo.sort;

import java.util.Arrays;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/5/17 16:13
 */
public class BucketSort2 {
    public static void main(String[] args) {
        int arry[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        bucketSort(arry);
        System.out.println(Arrays.toString(arry));
    }

    public static void bucketSort(int[] arry) {
        //1. 得到数组中最大的数的位数
        int max = arry[0];  //假设第一数就是最大数
        for (int i = 1; i < arry.length; i++) {
            if (arry[i] > max) {
                max = arry[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();
        //定义一个二维数组，表示 10 个桶, 每个桶就是一个一维数组
        // 说明
        // 1. 二维数组包含 10 个一维数组
        // 2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为 arr.length
        // 3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arry.length];
        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        // 可以这里理解
        // 比如：bucketElementCounts[0] , 记录的就是 bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //(针对每个元素的对应位进行排序处理)， 第一次是个位，第二次是十位，第三次是百位..
            for (int j = 0; j < arry.length; j++) {
                //取出每个元素的对应位的值
                int digitOfElement = arry[j] / n % 10; //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arry[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0; //遍历每一桶，并将桶中是数据，放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第 k 个桶(即第 k 个一维数组), 放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放入到 arr
                        arry[index++] = bucket[k][l];
                    }
                }
                //第 i+1 轮处理后，需要将每个 bucketElementCounts[k] = 0 ！！！！
                bucketElementCounts[k] = 0;
            }
            System.out.println("第" + (i + 1) + "轮，对个位的排序处理 arr =" + Arrays.toString(arry));
        }
    }
}
