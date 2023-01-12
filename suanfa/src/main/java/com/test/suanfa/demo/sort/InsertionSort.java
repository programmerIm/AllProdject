package com.test.suanfa.demo.sort;

/**
 * @auther :liming
 * @Description:插入排序    随机取一个,从末尾比较大的往后移动
 * @Date: create in 2020/4/28 22:46
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4 };
         inertSort(array);
         // sort(array);
         for (int i=0;i<array.length;i++){
             System.out.print(array[i]+" ");
         }
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

    public static  void inertSort(int[] array){
        for (int i =0;i<array.length;i++){
            for (int j= i-1;j>=0 && array[j]>array[j+1];j--){
                swap(array,j,j+1);
            }
        }
    }

    public  static  void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

    }
}
