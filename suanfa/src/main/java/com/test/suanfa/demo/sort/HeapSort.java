package com.test.suanfa.demo.sort;

import java.util.Arrays;

/**
 * @auther :liming
 * @Description: 堆排序  segment
 * @Date: create in 2020/6/17 11:55
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arry = {8,1,3,5,9,7,2,0};
        heapSort(arry); //进行升序排序
      //  heapSort2(arry); //进行降序排序
        System.out.println(Arrays.toString(arry));
    }

    public static void heapSort(int[] arry){
        // arry.length/2 -1 是第一个非叶子节点
        for (int i = arry.length / 2 - 1; i >=0; i--) {
            adjustHeap(arry, i, arry.length);
        }
        //进行交换,将堆顶数据和数组最后一位交换
        for (int j = arry.length - 1; j > 0; j--) {
            swap(arry,0,j);
            adjustHeap(arry, 0, j);
        }
    }

    /**
     * @param arry   数组
     * @param i      非叶子节点
     * @param length 数组长度
     */
    public static void adjustHeap(int[] arry, int i, int length) {
        int temp = arry[i]; //保存当前非叶子节点的数据
        //k 为 i 节点的左子节点
        for (int k = 2 * i + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arry[k] < arry[k + 1]) {//说明右子节点大于左子节点
                k++; //将k指向右节点
            }
            if (temp < arry[k]) {//当右子节点大于父节点
                arry[i] = arry[k];//把较大节点赋给当前节点
                i = k;
            }else {
                break;//注意这里是从左到右，从上到下的
            }
        }
        arry[i] = temp;
    }


    // 创建小根堆
    private static void heapSort2(int[] array) {
        // 初始化构造一个小根堆
        for (int i =array.length/2 -1;i>=0;i--){
            adjustHeap2(array,i,array.length);
        }

        // 堆顶最小值与数组最后一位进行交换
        for (int i = array.length-1;i>0;i--){
            swap(array,0,i);
            adjustHeap2(array,0,i);
        }
    }

    private static void adjustHeap2(int[] array, int index, int heapSize) {
        // 暂存当前值
        int temp = array[index];
        for (int k= 2* index+1;k<heapSize;k=2*k+1){
            // 找到最小的
            if(k+1<heapSize&& array[k]>array[k+1]){
                k++;
            }

            // 小的话交换位置
            if(temp > array[k]){
                array[index] = array[k];
                index = k;
            }else {
                break;
            }
        }
        array[index] = temp;
    }

    private static void swap(int[] array, int source, int target) {
        int temp = array[source];
        array[source] = array[target];
        array[target] = temp;
    }
}
