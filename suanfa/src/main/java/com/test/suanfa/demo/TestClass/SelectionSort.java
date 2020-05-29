package com.test.suanfa.demo.TestClass;

import java.util.Arrays;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/5/21 15:18
 */
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = { 8, 4, 5, 7, 1, 3, 6, 2 }; //
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        for(int i =0;i<arr.length;i++){
            int x = i;//当前位置
            for(int j = i+1;j<arr.length;j++ ){
                if(arr[x] > arr[j]){
                    x = j;
                }
            }
            int temp = arr[x];
            arr[x] = arr[i];
            arr[i] = temp;
        }
    }
}
