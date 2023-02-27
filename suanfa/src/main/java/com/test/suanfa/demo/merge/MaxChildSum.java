package com.test.suanfa.demo.merge;

public class MaxChildSum {

    public static void main(String[] args) {

        int[] nums = {10, 20, 30, 5, 10, 50};
        System.out.println(getNum(nums));
    }

    public static    int getNum(int[] nums) {
        // 用于计算截止当前位置升序的和
        int[] help = new int[nums.length];
        if (nums.length == 1) {
            help[0] = nums[0];
        }

        if (nums.length > 1) {
            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    help[i] = nums[i];
                } else {
                    if (nums[i] > nums[i - 1]) {
                        help[i] = help[i-1] + nums[i];
                    } else {
                        help[i] = nums[i];
                    }
                }
            }
        }


        int max = 0;
        for (int i = 0; i < help.length; i++) {
            max = Math.max(max, help[i]);
        }
        return max;
    }
}
