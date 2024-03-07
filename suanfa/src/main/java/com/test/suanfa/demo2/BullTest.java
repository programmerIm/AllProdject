package com.test.suanfa.demo2;

import java.util.*;

/**
 * @author :liming
 * @version 1.0
 * @Date :  2024/02/21/00:09
 * @Description
 */
public class BullTest {
    public static void main(String[] args) {
        int [] arr = {3,4,3,1,2};
        if (arr == null || arr.length < 2) {
            return;
        }
        // 找到整个数组中最大的数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }

}
