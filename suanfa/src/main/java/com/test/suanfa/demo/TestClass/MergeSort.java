package com.test.suanfa.demo.TestClass;

import java.util.Arrays;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/5/21 14:56
 */
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 }; //
        int temp[] = new int[arr.length]; //归并排序需要一个额外空间
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println("归并排序后=" + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arry,int left,int right,int [] temp){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(arry,left,mid,temp);
            mergeSort(arry,mid+1,right,temp);
            merge(arry,left,mid,right,temp);
        }
    }

    private static  void merge(int[] arry, int left, int mid, int right, int[] temp) {
        int i = left;//左边起始索引
        int j = mid+1;//右边起始索引
        int t = 0 ;//临时数组索引
        while (i<=mid&&j<=right){
            if(arry[i]<arry[j]){ //左边的大
                temp[t] = arry[i];
                ++t;
                ++i;
            }else {
                temp[t] = arry[j];
                ++t;
                ++j;
            }
        }
        //当左边还有剩余
        while (i<=mid){
            temp[t]=arry[i];
            i++;
            t++;
        }
        //当右边还有剩余
        while (j<=right){
            temp[t]=arry[j];
            j++;
            t++;
        }

        //将临时数组中的移动回去
        t = 0;
        int arryLeft = left;
        while (arryLeft<=right){
            arry[arryLeft] = temp[t];
            t++;
            arryLeft++;
        }
    }
}
