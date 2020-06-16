package com.test.suanfa.demo.sort;

import java.util.Arrays;

/**
 * @auther :liming
 * @Description:插入排序    随机取一个,从末尾比较大的往后移动
 * @Date: create in 2020/4/28 22:46
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4 };
         sort(array);
        System.out.println(Arrays.asList(array));
    }
    public static  void sort(int [] array){
       for(int i = 1;i<array.length;i++){  //从第二个一直抓到最后一个
           int current  = array[i]; //抓取的数（）
           int preindex = i-1;  //前一个数的索引
           while (preindex >=0 && array[preindex] > current ){
                array[preindex+1] = array[preindex];
               preindex--;
           }
           array[preindex+1]  = current ;//j+1最小为0,将该数插入
       }
    }
}
