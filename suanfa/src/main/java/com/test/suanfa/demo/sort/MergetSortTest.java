package com.test.suanfa.demo.sort;

import java.util.Arrays;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/4/30 11:38
 */
public class MergetSortTest {
    public static void main(String[] args) {
        int arry[] = {8, 4, 5, 7, 1, 3, 6, 2};
        int temp[] = new int[arry.length];
        mergeSort(arry, 0, arry.length - 1, temp);
        System.out.println(Arrays.toString(arry));
    }

    public static void mergeSort(int[] arry, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arry, left, mid, temp); //将左边进行拆分
            mergeSort(arry, mid + 1, right, temp);//将右边进行拆分
            merge(arry, left, mid, right, temp);//当拆分到最小单位时-合并
        }
    }

    public static void merge(int[] arry, int left, int mid, int right, int[] temp) {
        int l = left;//左边索引起始
        int j = mid + 1; //右边索引起始
        int t = 0; //临时数组的初始索引

        while (l <= mid && j <= right) {
            //当左边索引位置数据较小
            if (arry[l] < arry[j]) {
                temp[t] = arry[l];
                t += 1;
                l += 1;
            } else {//当右边索引位置数据较小
                temp[t] = arry[j];
                j += 1;
                t += 1;
            }
        }
        while (l <= mid) { //左边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arry[l];
            t += 1;
            l += 1;
        }

        while (j <= right) { //右边的有序序列还有剩余的元素，就全部填充到temp
            temp[t] = arry[j];
            t += 1;
            j += 1;
        }

        //将temp的数据移动到原数组
        t = 0; //temp当前索引
        int templeft = left; //临时数组起始索引
        while (templeft <= right) {
            arry[templeft] = temp[t];
            t += 1;
            templeft += 1;
        }
    }
}
