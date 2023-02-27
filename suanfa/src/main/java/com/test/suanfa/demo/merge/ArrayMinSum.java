package com.test.suanfa.demo.merge;

/**
 * 数组最小和
 *
 * @author liming522
 * @date 11:16
 */
public class ArrayMinSum {

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 2, 5};
        System.out.println("数组最小和为:" + getArrayMinSum(array));
    }

    public static int getArrayMinSum(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int[] ans = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    temp += array[j];
                }
            }
            ans[i] = temp;
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result += ans[i];
        }
        return result;
    }
}
