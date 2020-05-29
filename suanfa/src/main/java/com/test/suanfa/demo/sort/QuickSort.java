package com.test.suanfa.demo.sort;


/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/4/28 23:37
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2, 4};
        int left = 0;
        int right = array.length - 1;
        sort(array, left, right);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right)
            return;
        int partion_index = paration(array, left, right);//求基准的索引位置
        sort(array, left, partion_index - 1);//小于基准的子数组
        sort(array, partion_index + 1, right);//大于基准的子数组
    }

    private static int paration(int[] array, int left, int right) {
        int pivot = right; //每次将数组最右边的作为基准
        int tail = left - 1;//代表:小于基准的数组最后一位的索引，依次递增
        for (int i = left; i < right; i++) { //遍历数组中每一个数与基准去比较
            if (array[i] < array[pivot]) {
                swap(array, ++tail, i);//把小于等于基准的元素放到前一个子数组末尾
            }
        }
        // 最后把基准放到前一个子数组的后边（taik+1）为小于基准数组后一位， 剩下的子数组既是大于基准的子数组
        swap(array, tail + 1, pivot);
        return tail + 1;//返回当前基准的索引位置  ｛小于数组｝基准｛大于数组｝
    }
    private static void swap(int[] array, int k, int j) {
        int temp = array[k];
        array[k] = array[j];
        array[j] = temp;
    }
}
