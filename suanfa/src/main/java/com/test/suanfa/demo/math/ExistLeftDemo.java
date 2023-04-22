package com.test.suanfa.demo.math;

/**
 *  二分查找第一个等于目标数的最左索引、左右索引
 * @author liming522
 * @date 2022/12/28 15:18
 */
public class ExistLeftDemo {

    public static void main(String[] args) {
        int [] array = {1,2,2,4,5};
         int target = 2;
        System.out.println(existLeft(array,target));
        System.out.println(existRight(array,target));
    }

    // 返回等于目标数左边第一个
    private static int existLeft(int[] array, int target) {
        int L =0;
        int R = array.length-1;
        int index = -1;

        while (L<=R){
            int mid = L + ((R-L)>>1);

            //
            if(array[mid]>=target){
                index = mid;
                R = mid -1 ;
            }else {
                L = mid +1;
            }
        }
        return  index;
    }

    // 返回等于目标数右边第一个
    private static int existRight(int[] array, int target) {
        int L =0;
        int R = array.length-1;
        int index = -1;

        while (L<=R){
            int mid = L + ((R-L)>>1);
            if(array[mid]<=target){
                index  = mid;
                L = mid + 1 ;
            }else {
                R = mid - 1;
            }
        }
        return  index;
    }

}
