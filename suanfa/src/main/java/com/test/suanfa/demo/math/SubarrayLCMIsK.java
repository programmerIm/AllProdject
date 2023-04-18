package com.test.suanfa.demo.math;

/**
 * 最小公倍数为K的子数组数目问题
 * https://leetcode.cn/problems/number-of-subarrays-with-lcm-equal-to-k/
 * @author liming522
 * @date 2023/4/18 18:47
 */
public class SubarrayLCMIsK {
    public static void main(String[] args) {
         int[] array = {3,6};
        System.out.println(subarrayLCM(array,6));
    }
    public static  int subarrayLCM(int[] nums, int k) {
        int count = 0;
        for(int i = 0;i< nums.length;i++){
            int temp = nums[i];
            for(int j = i; j<nums.length;j++){
                // 判断是否是满足条件
                temp = temp * nums[j]/gcd(nums[j],temp);
                if(temp == k){
                    count ++;
                }else if(temp > k){
                    break;
                }
            }
        }
        return count;
    }

    public static int gcd(int a,int b){
        while(b!=0){
            int temp = a % b;
            a = b ;
            b = temp;
        }
        return a;
    }
}
