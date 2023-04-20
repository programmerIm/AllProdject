package com.test.suanfa.demo.stringDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长无重复子串
 * @author liming522
 * @date 2023/2/27 14:09
 */
public class DuplicateSubStr {
    public static void main(String[] args) {
       // String str = "abcadefgha";
        String str2 = "abbb";
       // System.out.println(getMaxSubString(str));
        System.out.println(getMaxSubString(str2));
    }

    private static int getMaxSubString(String str) {
        if(str.length()==0){
            return 0;
        }
        // 记录最大长度
        int maxLen  =  0;
        // 记录字符串最初的位置
        int start = 0;
        // map key是每个字符，value是每个字符串出现位置+1
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i< str.length();i++){
            char temp = str.charAt(i);

            // 决定起始位置是否变化
            if(map.containsKey(temp)){
                // 如果上一次出现的位置大于start，新字符串起始位置就从上一次出现的位置开始算
                // 不断的更新不重复字符串的起始位置
               start = Math.max(start, map.get(temp));
            }
            maxLen = Math.max(maxLen,i-start+1);
            // 记录每个字符出现的位置+1,可以覆盖
            map.put(temp,i+1);
        }

        return maxLen;
    }
}
