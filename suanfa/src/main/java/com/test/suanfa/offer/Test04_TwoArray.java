package com.test.suanfa.offer;

/**
 * @auther :liming
 * @Description: 查找二维数组中存在不存在一个数
 * @Date: create in 2020/6/23 14:48
 */
public class Test04_TwoArray {
    public static void main(String[] args) {
        int [][] nums = {
                {1, 4,  7, 11, 15},
                {2, 5,  8, 12, 19},
                {3,  6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(nums,31));
    }

    public static  boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;//一共有多少行
        int clums = matrix[0].length;//一共有多少列
        if (matrix[0][clums - 1] == target) { //先判断右上角的
            return true;
        } else {
            int i = 0;  //横向索引
            int j = clums - 1; //纵向索引
            boolean flag = false;
            while (i <= rows - 1 && j >= 0) {
                if (matrix[i][j] > target) {//大于目标数 ，向左移动
                    j--;
                } else if (matrix[i][j] < target) {//小于目标数，向下移动
                    i++;
                } else {
                    flag = true;
                    break;
                }
            }
            return flag;
        }
    }
}
