package com.test.suanfa.demo.stringDemo;


import java.util.HashSet;

/**
 * 最长重复子串
 *
 * @author liming522
 * @date 2023/2/27 14:47
 */
public class MaxDuplicateSubStr {

    public static void main(String[] args) {
        String str = "abcadabc";
        System.out.println(getMaxSubStr(str));
    }

    private final static int PRIME = 31;

    private static String getMaxSubStr(String str) {
        String ans = "";
        // 首先二分法找子串
        int left = 0;
        int right = str.length() - 1;
        // 从 left 到 right这几个长度中，用二分法找满足的字串长度
        while (left <= right) {
            // mid 代表的是查找的子串的长度，如果当前mid找到就尝试找比他大一位的。
            int mid = left +(right - left+ 1) / 2;
            String x = check(str, mid);
            if (!x.equals("")) {
                left = mid + 1;
                ans = x;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // 利用滑动窗口去计算
    private static String check(String str, int mid) {
        String ans = "";

        HashSet set = new HashSet();
        long hash = 0;
        // 滑动窗口的指数权重
        long pow = 1;
        for (int i = 0; i < mid; i++) {
            hash = PRIME * hash + str.charAt(i);
            pow *= PRIME;
        }
        // 添加初始窗口
        set.add(hash);

        for (int i = 0; i < str.length() - mid; i++) {
            hash = PRIME * hash + str.charAt(i + mid) - pow * str.charAt(i);
            if (set.contains(hash)&& str.indexOf(ans= str.substring(i + 1, i + mid + 1)) < i + 1) {
                    return ans;
            }
            set.add(hash);
        }
        return ans;
    }
}
