package com.test.suanfa.demo.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 三数之和
 *
 * @author liming522
 * @date 2023/3/1 16:22
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] array = {1, 2, -2, -1};
        System.out.println(getThreeSum(array));
    }

    private static List<List<Integer>> getThreeSum(int[] array) {
        // 首先对array 进行排序
        sort(array, 0, array.length - 1);
        List<List<Integer>> ans = new ArrayList<>();

        for (int first = 0; first < array.length; first++) {
            // 第一个数大于0，那其余的基本都大于0，不合适
            if (first > 0 && array[first] == array[first - 1]) {
                continue;
            }

            int third = array.length - 1;
            for (int second = first + 1; second < third; second++) {
                // 当前数与前一个相同时，去重
                if (second > first + 1 && array[second] == array[second - 1]) {
                    continue;
                }

                // 之和大于0，就第三个数往下减
                while (second < third && array[second] + array[third] + array[first] > 0) {
                    third--;
                }

                if (second == third) {
                    break;
                }

                if (array[second] + array[third] + array[first] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(array[first]);
                    list.add(array[second]);
                    list.add(array[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    private static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int papartion = papartion(array, left, right);
        sort(array, left, papartion - 1);
        sort(array, papartion + 1, right);
    }

    private static int papartion(int[] array, int left, int right) {
        int privot = right;
        int minIndex = left - 1; // 避免数组越界

        for (int i = left; i <= right; i++) {
            if (array[i] < array[privot]) {
                swap(array, ++minIndex, i);
            }
        }
        // 最后将基本放到小于数组最后
        swap(array, minIndex + 1, privot);
        return minIndex + 1; //返回新基准位置
    }


    private static void swap(int[] array, int source, int target) {
        int temp = array[target];
        array[target] = array[source];
        array[source] = temp;
    }

}
