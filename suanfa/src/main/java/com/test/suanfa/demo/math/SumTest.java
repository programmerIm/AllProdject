package com.test.suanfa.demo.math;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author liming522
 * @date 2023/2/27 10:24
 * 求两数之和
 * @return null
 */
public class SumTest {

    public static void main(String[] args) {
        int target = 10;
        int[] array = {1,2,3,9,8,7};
        System.out.println(Arrays.toString(getIndex(array,target)));
        System.out.println(Arrays.toString(getIndex2(array,target)));
    }

    // 双指针的算法，时间复杂度小于n^2
    private static int[] getIndex(int[] array, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right = array.length-1;
        for(int i =0;i<array.length;i++){
            for(int j=array.length-1;j>0;j--){
                // 双指针相遇了退出,前指针找下一个
                if(i>=j){
                    break;
                }
                // 内层循环先判断，找到一个和相同就退出
                if(array[i]+array[j]==target){
                    left = i ;
                    right = j;
                    break;
                }
            }
            // 外层循环后判断，找到就退出
            if(array[left]+array[right]==target){
                ans[0] = left;
                ans[1] = right;
                break;
            }
        }
        return ans;
    }

    // 借助额外空间进行缓存
    public static int[] getIndex2(int[] array,int target){
            int[] ans = new int[2];
            // key是对应的值，value是下标
         HashMap<Integer, Integer> map = new HashMap<>();
         for (int i = 0;i<array.length;i++){
             // 假如找到了当前数的差值,代表找到了
             if(map.containsKey(target-array[i])){
                ans[0] = i;
                ans[1] = map.get(target-array[i]);
                break;
             }
             map.put(array[i],i);
         }
        return ans;
    }
}
