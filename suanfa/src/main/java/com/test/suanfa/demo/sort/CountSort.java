package com.test.suanfa.demo.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @auther :liming
 * @Description:计数排序  原始数组的值代表新数组的索引位置   比如  5，4，3 ,6    5代表新数组 第5个位置计数一次
 * @Date: create in 2020/5/16 15:06
 */
public class CountSort {
    public static void main(String[] args) {
        int [] arry = {6, 5, 3, 1, 8, 7, 2, 4};
        countSort(arry);
        System.out.println(Arrays.toString(arry));
    }

    public static  void countSort(int [] aray){
        //求出原数组最大值
        int maxValue = 0;
        for(int i =0;i<aray.length;i++){
            if(aray[i]>maxValue){
                maxValue = aray[i];
            }
        }
        //创建新的数组为原数组最大值+1
        int [] temp = new int[maxValue+1];
        for(int j=0;j<aray.length;j++){ //遍历原始数组，去计数（原始数组元素大小即为新数组索引，出现一次➕1一次）
           int index =  aray[j];
           temp[index] +=1;
        }

        //遍历新数组去替换原始数组
        int arryIndex = 0;
        for(int k=0;k<temp.length;k++){
            if(temp[k]!=0){
                aray[arryIndex] = k;
                arryIndex+=1;
            }
        }
    }
}
