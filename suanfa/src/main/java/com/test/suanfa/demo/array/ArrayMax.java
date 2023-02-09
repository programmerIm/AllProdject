package com.test.suanfa.demo.array;

/**
 * 递归求数组最大值
 * @author liming522
 * @date 2023/2/7 17:57
 */
public class ArrayMax {

    public static Integer getMax(int[] array){
        return process(array,0,array.length-1);
    }

    private static Integer process(int[] array, int left, int right) {
        if(left==right){
            return array[left];
        }

        int mid = left + ((right-left)>>1);
        int leftMax = process(array,left,mid);
        int rightMax = process(array,mid+1,right);
        return Math.max(leftMax,rightMax);
    }


    public static void main(String[] args) {
        int[] arry = {1,9,4,5,7,11,15};
        System.out.println(getMax(arry));
    }
}
