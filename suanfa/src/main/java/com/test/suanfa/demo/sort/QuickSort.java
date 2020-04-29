package com.test.suanfa.demo.sort;


/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/4/28 23:37
 */
public class QuickSort {
    public static void main(String[] args) {
        int [] array = {6, 5, 3, 1, 8, 7, 2, 4 };
        int left = 0;
        int right = array.length-1;
        sort(array,left,right);
        for(int i:array){
            System.out.print(i+" ");
        }
    }

    private static void sort(int[] array,int left,int right) {
        if (left >= right)
            return;
        int partion_index = paration(array,left,right);
        sort(array,left,partion_index-1);
        sort(array,partion_index+1,right);
    }

    private static int paration(int[] array, int left, int right) {
       int pivot = right ; //每次将数组最右边的作为基准
        int  tail = left - 1;//将小于基准的数组最后一位索引
        for(int i = left;i<right;i++){
            if(array[i]<array[pivot]){
                swap(array,++tail,i);
            }
        }
        swap(array, tail + 1, right);
        return tail + 1;
    }
    private static void swap(int[] array, int k,int j ) {
        int temp = array[k];
        array[k] = array[j];
        array[j] = temp;
    }

}
