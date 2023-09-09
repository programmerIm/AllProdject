package com.test.suanfa.demo.array;


/**
 * 长度最小的连续子数组
 */
public class MinSubArray {
    public static void main(String[] args) {

    }

    public int test1(){
        int [] array = {2,3,1,2,4,3};
        int target = 7;
        int result = Integer.MAX_VALUE;
        for (int i=0;i<array.length;i++){
            int tempSum = array[i];
            if(tempSum >= target){
                result = 1;
                break;
            }
            for (int j=i+1;j<array.length;j++){
                if(tempSum+array[j]>=target){
                    result = Math.min(result,j-i+1);
                    break;
                }
                tempSum= tempSum+array[j];
            }
        }
        return result==Integer.MAX_VALUE?0:result;
    }

    public  int  test2(){
        int [] array = {2,3,1,2,4,3};
        int target = 7;
        int result = array.length+1;
        // 滑动窗口做法
        int left = 0;
        // 枚举右端点，从0到n-1
        int sum = 0;
        for (int right = 0;right<array.length;right++){
            sum += array[right];
            // 移动左端点,判断如果减去对应的左端点是否还大于target
            while (sum - array[left]>=target){
                sum -=array[left];
                left +=1;
            }
            if(sum>=target){
                result = Math.min(result,right-left+1);
            }
        }
        return result==array.length+1?0:result;
    }
}
