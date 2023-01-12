package com.test.suanfa.demo;

/**
 * 二分查找判断是否存在一个数
 * @author liming522
 * @date 2022/12/28 14:54
 */
public class ExistDemo {

    public static void main(String[] args) {
        int [] array = {1,3,6,7,9,10,12};

        int num = 12;
        System.out.println(exist(array, num));
    }

    private static boolean exist(int[] array, int num) {
        int L = 0;
        int R = array.length-1;
        int mid = 0;

        while (L<R){
            mid = L + ((R-L)>>1);

            if(array[mid]>num){
                R = mid-1;
            }else if(array[mid]< num) {
                L = mid+1;
            }

            if(array[mid]==num){
                return   true;
            }
        }
        return  array[R]==num;
    }
}
