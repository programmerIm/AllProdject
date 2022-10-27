package com.test.suanfa.demo.Duplicate;

/**
 * @author: liming522
 * @description:
 * @date: 2022/10/24 3:53 PM
 * @hope: The newly created file will not have a bug
 */
public class Demo1 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 4, 6, 7, 8, 9, 4};

        int tar = nums[0];

        // 查找过的标记为该去的位置
        while (tar != nums[tar]) {
            int temp = tar;
            tar = nums[tar];
            nums[temp] = temp;
        }
        System.out.println("重复的数是" + tar);
    }

    public static void main2() {
        int[] nums = {1, 2, 3, 5, 4, 6, 7, 8, 9, 4};

        int tar = nums[0];

        // 将查找过的标记为0
        while (0 != nums[tar]) {
            int temp = tar;
            tar = nums[tar];
            nums[temp] = 0;
        }
        System.out.println("重复的数是" + tar);
    }
}
