package com.test.suanfa.demo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/4/25 23:41
 */
public class AllSort {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        System.out.println( permute(array));
    }

    public static  List<List<Integer>> permute(int[] nums) {
      List<List<Integer>> result = new ArrayList<>();
        //第一次循环
        for (int i=0;i<nums.length;i++){
            int frist = nums[i];//先遍历一次数组，第一个位置填写的数量等于数组数量
            List<Integer> list= new LinkedList<>();
            list.add(frist);
            cycleFor(nums,i,list);
            result.add(list);
        }

        return  result;
    }

    public static  void cycleFor(int[] nums,int prex ,List list){
        if(prex==nums.length-1){

        }
        for(int next =prex+1;next<nums.length;next++){
            int nextValue  = nums[next];
            list.add(nextValue);
            cycleFor(nums,next,list);
        }
    }
}
