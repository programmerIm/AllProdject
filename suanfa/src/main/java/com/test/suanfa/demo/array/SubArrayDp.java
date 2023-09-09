package com.test.suanfa.demo.array;

import java.util.Arrays;

/**
 *  最长自增子序列
 */
public class SubArrayDp {
    public static void main(String[] args) {
        int[] array = {10,9,2,5,3,7,101,18};

        method1(array,array.length);
    }


    public  static  int method1(int A[], int n){
            // 创建一个大小为 n 的辅助数组
            int[] tailTable = new int[n];
            int len; // 存储辅助数组的元素个数

            //边界情况，将数组中的第一个元素直接添加进去
            tailTable[0] = A[0];
            len = 1; //长度加 1

            for (int i = 1; i < n; i++) {
                // 新的最小值，情况一
                if (A[i] < tailTable[0])
                {
                    tailTable[0] = A[i];
                }
                else if (A[i] > tailTable[len - 1]){
                    // A[i] 为最大值，情况二
                    tailTable[len++] = A[i];
                }
                else{ // 情况三，找到 A[i] 在 tailTable 的位置并替换
                    tailTable[getIndex(tailTable, -1, len - 1, A[i])] = A[i];
                }
            }
            return len;
    }

    // 二分查找某个key该存放的位置
    public static  int getIndex(int[]array,int left,int right,int key){
        while (right-left>1){
          int  mid = left + (right-left)/2;
            if(array[mid]>=key){
                right = mid;
            }else {
                left = mid;
            }
        }
        return  right;
    }

    // 普通动态规划问题，辅助数组含义为以某个节点为结尾，其余自增子序列多长
    public static  int method2(){
        int[] array = {1,10,4,6,8,11,2};
        int maxLength = 1;
        // result[i] 代表以i坐标为结尾的数，其最长的自增子序列是多长
        int[] result = new int [array.length];

        // 以i为结尾
        for (int i = 0;i<array.length;i++){
            result[i] = 1;
            // 其前一个数，是否比其小，如果比其小用 Math.max(array[j] + 1 ,result[i])
            for (int j = 0;j<array.length;j++){
                if(array[i]>array[j]){
                    result[i] = Math.max(result[j]+1,result[i]);
                }
            }
            maxLength = Math.max(maxLength,result[i]);
        }
        return  maxLength;
    }

}
