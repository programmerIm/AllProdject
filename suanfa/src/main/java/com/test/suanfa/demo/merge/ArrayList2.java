package com.test.suanfa.demo.merge;

/**
 * @author liming522
 * @date 2023/2/22 14:42
 * 升序队
 */
public class ArrayList2 {
    public static void main(String[] args) {
        int[] array = {1, 3, 7, 0, 2};
        // {1,3} {1,7} { 1,2} {3,7} {0,2}
        System.out.println("升序对一共有" + process(array, 0, array.length - 1));
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

//        public static int process(int[] array, int l, int r) {
//            if (l == r) {
//                return 0;
//            }
//            int mid = l + ((r - l) >> 1);
//            return process(array, l, mid) +
//                    process(array, mid + 1, r) +
//                    merge(array, l, mid, r);
//        }
//
//        public static int merge(int[] array, int l, int mid, int r) {
//            int[] help = new int[r - l + 1];
//            int p1 = l;
//            int p2 = mid + 1;
//            int ans = 0;
//
//            int helpIndex = 0;
//            // 合并的流程
//            while (p1 <= mid && p2 <= r) {
//                if(array[p1] < array[p2]){ // p1 < p2 则，p1小于p2往后的所有数
//                    ans+= r - p2 + 1;
//                    help[helpIndex] = array[p1];
//                    p1++;
//                    helpIndex++;
//                }else {
//                    ans+=0;
//                    help[helpIndex] = array[p2];
//                    helpIndex++;
//                    p2++;
//                }
//            }
//
//            while (p1<=mid){
//                help[helpIndex] = array[p1];
//                p1++;
//                helpIndex++;
//            }
//
//            while (p2<=r){
//                help[helpIndex] = array[p2];
//                p2++;
//                helpIndex++;
//            }
//
//            for (int i=0;i<help.length;i++){
//                array[l+i] = help[i];
//            }
//
//            return ans;
//        }


    //


    public static int process(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(nums, l, mid) +
                process(nums, mid + 1, r) +
                merge(nums, l, mid, r);
    }

    public static int merge(int[] nums, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int p1 = l;
        int p2 = mid + 1;
        int helpIndex = 0;
        int ans = 0;

        while (p1 <= mid && p2 <= r) {
            if (nums[p1] > nums[p2]) {
                ans += mid - p1 + 1;
                help[helpIndex] = nums[p2];
                helpIndex++;
                p2++;
            } else {
                help[helpIndex] = nums[p1];
                helpIndex++;
                p1++;
            }
        }

        while (p1 <= mid) {
            help[helpIndex] = nums[p1];
            helpIndex++;
            p1++;
        }

        while (p2 <= r) {
            help[helpIndex] = nums[p2];
            helpIndex++;
            p2++;
        }

        for (int i = 0; i < help.length; i++) {
            nums[l + i] = help[i];
        }
        return ans;
    }
}
