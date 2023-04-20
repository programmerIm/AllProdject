package com.test.suanfa.demo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 数组子集的个数
 * 2. 选取指定n个数进行排列，有多少种可能情况
 * 3. 排序去除重复的子集
 * @author liming522
 * @date 2023/4/20 14:49
 */
public class SubArrays {
        public static void main(String[] args) {
            int [] nums = {2,1,2};
            Arrays.sort(nums);
            System.out.println(Arrays.toString(nums));
            System.out.println(subsets(nums));
        }

        static public List<List<Integer>> subsets(int[] nums) {
            backTracking(nums, 0);
            return result;
        }

        static List<List<Integer>> result = new ArrayList<List<Integer>>(); // 用于存放所有的结果集
        static List<Integer> temp = new ArrayList<>();  // 用于存放当前的结果集

        public  static  void backTracking(int[] nums, int index) {
            if (index == nums.length) {
                result.add(new ArrayList<Integer>(temp));
                return;
            }

            temp.add(nums[index]);
            backTracking(nums, index + 1);
            temp.remove(temp.size() - 1);
            while (index< nums.length-1 && nums[index] == nums[index+1]){
                index++;
            }
            backTracking(nums, index + 1);
        }

        public  static  void backTracking2(int[] nums, int index) {
            if (index == nums.length) {
                // 选4个数进行组合的情况
                if(temp.size()==4){
                    result.add(new ArrayList<Integer>(temp));
                }
                return;
            }

            temp.add(nums[index]);
            backTracking(nums, index + 1);
            temp.remove(temp.size() - 1);
            backTracking(nums, index + 1);
        }

        // 返回任意顺序不重复的字集
        public  static  void backTracking3(int[] nums, int index) {
            if (index == nums.length) {
                result.add(new ArrayList<Integer>(temp));
                return;
            }

            temp.add(nums[index]);
            backTracking(nums, index + 1);
            temp.remove(temp.size() - 1);
            while (index < nums.length-1 && nums[index]==nums[index+1]){
                index++;
            }
            backTracking(nums, index + 1);
        }
}
