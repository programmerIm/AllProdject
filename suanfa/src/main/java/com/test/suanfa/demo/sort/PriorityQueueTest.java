package com.test.suanfa.demo.sort;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,3,7,8,9};
        int k = 4;
        // 大顶堆
         PriorityQueue<Integer> queue = new PriorityQueue<>(4, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }

        });

        for (int i = 0; i < nums.length; i++) {
            if(queue.size()!=k){
                queue.offer(nums[i]);
            }else if(queue.peek()> nums[i]) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.println(queue.poll());
        }
    }
}
