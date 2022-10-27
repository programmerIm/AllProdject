package com.test.suanfa.demo.Duplicate;

/**
 * @author: liming522
 * @description:
 * @date: 2022/10/24 3:57 PM
 * @hope: The newly created file will not have a bug
 */
public class Demo2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 4, 5, 6, 7, 8, 9};
        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        while (right-left == 1) {
            if (nums[mid] == mid) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.println("重复的数是" + nums[mid]);
    }
}
