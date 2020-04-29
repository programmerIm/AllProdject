package com.test.suanfa.demo.sort;

/**
 * @auther :liming
 * @Description:插入排序    随机取一个,从末尾比较大的往后移动
 * @Date: create in 2020/4/28 22:46
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4 };
         sort(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
    public static  void sort(int [] array){
       for(int i = 1;i<array.length;i++){  //从第二个一直抓到最后一个
           int get = array[i]; //抓取的数（）
           int j = i-1;  //前一个数
           while (j >=0 && array[j] > get){
                array[j+1] = array[j];
                j--;
           }
           array[j+1]  = get;//j+1最小为0
       }
    }
}
