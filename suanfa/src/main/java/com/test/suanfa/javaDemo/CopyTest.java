package com.test.suanfa.javaDemo;

import java.util.HashSet;
import java.util.Set;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/4/21 0:01
 */
public class CopyTest {
    public static  int findRepeatNumber(int[] nums) {
        Set<Integer> example = new HashSet<Integer>(); //存放种类
         int num = 0;
        for(int i=0;i<nums.length;i++){
            if (example.contains(nums[i])) {
                num = nums[i];
                break;
            }else {
                example.add(nums[i]);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
