package com.test.suanfa.demo.array;

/**
 * 矩阵顺时针打印
 *
 * @author liming522
 * @date 2023/3/4 18:42
 */
public class Juzhen {

    public static void main(String[] args) {
        int[][] arry = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] ints = printJuzhen(arry);
        for (int i=0; i<ints.length;i++){
            System.out.print(ints[i]);
        }
    }

    private static int[] printJuzhen(int[][] array) {
        if(array==null||array.length==0){
            return new int[0];
        }
        int colunms = array.length;
        int rows = array[0].length;
        int[] result = new int[rows * colunms];
        // 结果的索引
        int index = 0;

        // 初始化上下左右的值
        int top = 0, botom = colunms - 1, left = 0, right = rows - 1;
        while (left <= right && top <= botom) {
            // 从左到右打印横行
            for (int i = left; i < right; i++) {
                result[index++] = array[top][i];
            }

            // 从上往下打印列
            for (int j = top; j <= botom; j++) {
                result[index++] = array[j][right];
            }

            if (left < right && top < botom) {
                // 从右往左打印
                for (int i = right - 1; i >= left; i--) {
                    result[index++] = array[botom][i];
                }

                // 从下往上打印
                for (int j = botom - 1; j > top; j--) {
                    result[index++] = array[j][left];
                }
            }
            top++;
            botom--;
            left++;
            right--;
        }
        return result;
    }
}
