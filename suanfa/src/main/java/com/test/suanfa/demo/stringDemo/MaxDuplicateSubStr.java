package com.test.suanfa.demo.stringDemo;


import java.util.HashSet;
import java.util.Set;

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
            // mid 代表的是查找的子串的长度，如果当前mid找到就尝试找比他大一位的。没找到就找比他小一位的
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
    private static String check(String str, int len) {
        String ans = "";
        // 保存之前出现过的hash值
        Set<Long> seen = new HashSet<>();
        // 先计算原始窗口的hash值
        // hash初始化为0
        long hash = 0;
        // 当前窗口的指数权重:用于退出窗口字符串的hash计算
        long pow = 1;
        for(int i = 0; i < len; i++) {
            hash = PRIME * hash + str.charAt(i);
            pow *= PRIME;
        }
        // 首个长度为len的字符串hash也要加入seen
        seen.add(hash);
        // 开始遍历s中每一个长度为len的窗口判断是否出现过重复的字符串
        // 以当退出窗口的索引i为遍历基准:[0,1,2,3,4],len=3->因此退出窗口的有i=0,1
        for(int i = 0; i < str.length() - len; i++) {
            // 计算当前窗口的hash值
            hash = hash * PRIME + str.charAt(i + len) - pow * str.charAt(i);
            // 若之前出现过该hash值 && 当前截取的字符串在之前已经出现过:说明出现了重复子串
            // 这里要充分利用seen.contains(hash)的短路效应可以大大提升效率!!!
            if(seen.contains(hash) && str.indexOf(ans = str.substring(i + 1, i + len + 1)) < i + 1) {
                return ans;
            }
            // 别忘了添加当前hash
            seen.add(hash);
        }
        // 没找到重复的就返回""
        return ans;
    }
}
