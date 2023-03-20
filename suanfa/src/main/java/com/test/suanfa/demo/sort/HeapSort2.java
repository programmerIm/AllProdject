package com.test.suanfa.demo.sort;

import java.util.Arrays;

public class HeapSort2 {
    public static void main(String[] args) {
        int [] array = {8,1,3,5,9,7,2,0};

        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    // 堆排序额外空间复杂度O(1)
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // 方案一 O(N*logN)
        /*for (int i = 0; i < arr.length; i++) { // O(N)
           heapInsert(arr, i); // O(logN)
        }*/

        // 方案二
       for (int i = arr.length - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        } //优化方案，默认当前数组已经是个堆，然后变成一个大根堆*/

        int heapSize = arr.length;
        // O(N*logN)
        while (heapSize > 0) { // O(N)
            swap(arr, 0, --heapSize); // O(1)
            heapify(arr, 0, heapSize); // O(logN)
        }
    }

    // arr[index]刚来的数，往上
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // arr[index]位置的数，能否往下移动
    public static void heapify(int[] arr, int index, int heapSize) {
       int left = index * 2 + 1; // 左孩子的下标
        while (left < heapSize) { // 下方还有孩子的时候
            // 两个孩子中，谁的值大，把下标给largest
            // 1）只有左孩子，left -> largest
            // 2) 同时有左孩子和右孩子，右孩子的值<= 左孩子的值，left -> largest
            // 3) 同时有左孩子和右孩子并且右孩子的值> 左孩子的值， right -> largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            // 父和较大的孩子之间，谁的值大，把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }


      // i 为当前非叶子节点，其左子节点为 2*i+1
     /*   for (int k = 2 * index + 1; k < heapSize; k = 2 * k + 1) {
            // 找到两个子节点中大的那一个
            int largest = k;
            if (k + 1 < heapSize && arr[k] < arr[k + 1]) {
                largest = k + 1;
            }

            if (arr[k] > arr[index]) {
                // 子节点与父节点进行交换
                swap(arr, index, largest);
                k = largest;
                index = k;
            }else {
                break;
            }
        }*/
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
