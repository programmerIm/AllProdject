package com.test.suanfa.demo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @auther :liming
 * @Description: 桶排序
 * @Date: create in 2020/5/17 0:10
 */
public class BucketSort {
    public static void main(String[] args) {
        int arry[] = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        bucketSort(arry);
        System.out.println(Arrays.toString(arry));
    }

    public static void bucketSort(int[] arry) {
        int maxValue = 0;
        int minValue = 0;
        for (int i = 0; i < arry.length; i++) {
            maxValue = Math.max(maxValue, arry[i]);
            minValue = Math.min(minValue, arry[i]);
        }

        //计算桶的数量
        int bucketNum = (maxValue - minValue) / arry.length+1;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        //为每个桶子填充数据
        for (int i = 0; i < arry.length; i++) {
            buckets.get((arry[i] - minValue) / arry.length).add(arry[i]);
        }
        //每个桶子排序
        for (int i = 0; i < bucketNum; i++) {
            Collections.sort(buckets.get(i));
        }

        //替换数组
        int t = 0;
        for (int i = 0; i < buckets.size(); i++) {
            for (int j = 0; j < buckets.get(i).size(); j++) {
                arry[t] = buckets.get(i).get(j);
                t++;
            }
        }
    }
}
