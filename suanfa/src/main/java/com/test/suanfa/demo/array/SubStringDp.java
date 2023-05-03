package com.test.suanfa.demo.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 最长子串链
 * 前一个是后一个前身，后一个字符串比前一个只多了某个字符
 */
public class SubStringDp {
    public static void main(String[] args) {
        String[] words = {"a","b","abc"} ;
        // 升序
        Arrays.sort(words,(a,b)->a.length()-b.length());
        int result = 0;

        // 用于存储以某个字符结尾，其串链长度
        Map<String,Integer> map = new HashMap<>();
        for (String word:words){
            map.put(word,1);
            for (int i=0;i<word.length();i++){
                // 每次剔除i字符判断
                String prex = word.substring(0,i)+ word.substring(i+1);
                if(map.containsKey(prex)){
                    map.put(word,Math.max(map.get(word),map.get(prex)+1));
                }
            }
            result = Math.max(result,map.get(word));
        }
    }
}
