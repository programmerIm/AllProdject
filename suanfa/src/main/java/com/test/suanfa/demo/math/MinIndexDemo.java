package com.test.suanfa.demo.math;

/**
 * 求局部最小值
 * @author liming522
 * @date 2022/12/28 15:55
 */
public class MinIndexDemo {
    public static void main(String[] args) {

        int [] array = {1,2,2,3,4,3};

    }

    public  static  Integer minIndex(int[] array){
        if(array==null || array.length ==0){
            return null;
        }

        if(array.length == 1 ){
            return 0;
        }

        // 左边界
        if(array[0] < array[1]){
            return 0;
        }

        // 右边界
        if(array[array.length-2] > array[array.length-1]){
            return  array.length-1;
        }

        // 刨除左右边界
        int L = 0;
        int R = array.length -1;
        int mid = 0;
        while (L<=R){
           mid = (L + R) /2 ;
           if(array[mid] > array[mid+1]){
               L = mid + 1;
           }else if(array[mid] > array[mid-1]){
               R  = mid- 1;
           }
        }
        return  mid;
    }


}
