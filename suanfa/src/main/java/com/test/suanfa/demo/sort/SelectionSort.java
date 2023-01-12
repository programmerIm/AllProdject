package com.test.suanfa.demo.sort;

/**
 * @auther :liming
 * @Description:选择排序:每次也是找到最大或者最小，与冒泡不同的是，只移动最大的或者最小的那个去列首（列尾）
 * @Date: create in 2020/4/28 22:17
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] array = {6, 5, 3, 1, 8, 7, 2,2, 4};
        sort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] array) {
        int n = array.length;//数组长度
        for (int i = 0; i < n - 1; i++) { // 首轮即需要找 n-1 个最小值
            int min = i; //每次最小的索i引位置
            for (int j = i + 1; j < n; j++) { //拿第一个与其他比较，找到最小的交换到最前
                if (array[min] > array[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(array, i, min);
            }
        }
    }

    private static void swap(int[] array, int k, int j) {
        int temp = array[k];
        array[k] = array[j];
        array[j] = temp;
    }
}
