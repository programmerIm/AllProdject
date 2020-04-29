package com.test.suanfa.demo.sort;

/**
 * @auther :liming
 * @Description: 冒泡排序，每轮找到最大值
 * @Date: create in 2020/4/28 21:45
 */
public class BubbleSort {
    public static void main(String[] args) {
      int[] array = {6, 5, 3, 1, 8, 7, 2, 4 };
        cookSort(array);
       // sort(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }

   //普通冒泡排序
    public static void sort(int[] array){
        for (int j=0;j<array.length;j++){ //按数组大小决定整体要找多少次最大值
            for(int k=0;k<array.length-1-j;k++){//除去右边已经找到的大值
                if(array[k]>array[k+1]){ //当左边大于右边时，进行互换
                    swap(array,k,k+1);
                }
            }
        }
    }

    /**
     * 机尾 冒泡排序 是普通的升级，先从小到大，然后从大到小
     * @param array
     */
    public static  void cookSort(int[] array){
        int left = 0;
        int right = array.length - 1;
        while (left<right){
            for(int i =left;i<right;i++){  //从从小到大
                if(array[i]>array[i+1]){
                    swap(array,i,i+1);
                }
            }
            right--;
            for(int j=right;j>left;j--){ //从大到小
                if(array[j-1]>array[j]){
                    swap(array,j-1,j);
                }
            }
            left ++;
        }

    }

    private static void swap(int[] array, int k,int j ) {
        int temp = array[k];
        array[k] = array[j];
        array[j] = temp;
    }

}
