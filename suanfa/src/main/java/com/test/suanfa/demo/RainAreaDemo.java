package com.test.suanfa.demo;

/**
 * @auther :liming
 * @Description: 雨滴面积
 * @Date: create in 2020/4/18 23:56
 */
public class RainAreaDemo {
    public static void main(String[] args) {
        int [] rain = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(rain));
    }
    public static  int trap(int [] height){
        int left_index = 0;
        int right_index = height.length-1;
        int max_left =0 ;
        int max_right = 0;
        int max_area = 0;
        while (left_index<=right_index){
            if(max_left<max_right){ //当左边低
               max_area += Math.max(0,max_left-height[left_index]);
               max_left = Math.max(max_left,height[left_index]);
               left_index+=1;
            }else {
                max_area  += Math.max(0,max_right-height[right_index]);
                max_right = Math.max(max_right,height[right_index]);
                right_index -=1;
            }
        }
        return max_area;
    }
}
