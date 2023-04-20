package com.test.suanfa.demo.Duplicate;

/**
 * @author: liming522
 * @description: 顺序数组中查找重复的数
 * @date: 2022/10/24 3:53 PM
 * @hope: The newly created file will not have a bug
 */
public class DuplicateNum {

    public static void main(String[] args) {
        method1();
      //  method2();
    }

    public static void method1(){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 4};

        int tar = nums[0];

        // 查找过的标记为该去的位置
        while (tar != nums[tar]) {
            int temp = tar;
            tar = nums[tar];
            nums[temp] = temp;
        }
        System.out.println("重复的数是" + tar);
    }

    public static void method2() {
        int[] nums = {1, 2, 3, 5, 1, 6, 7, 8, 9, 4};

        int tar = nums[0];

        // 将查找过的标记为0
        while (0 != nums[tar]) {
            int temp = tar;
            tar = nums[tar];
            nums[temp] = 0;
        }
        System.out.println("重复的数是" + tar);
    }

    public static void main3(){
        int[] nums = {1, 2, 3, 5, 4, 6, 7, 8, 9, 4};
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

    public static void main4(){
        int[] nums = {1, 2, 3, 5, 4, 6, 7, 8, 9, 4};
        int tar = nums[0];
        while (0!=nums[tar]){

        }
    }
}
