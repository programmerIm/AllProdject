package com.test.suanfa.demo.stringDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * // 构造最大回文字符串
 * @author liming522
 * @date 2023/3/1 01:40
 */
public class BuildMaxHuiWen {
    public static void main(String[] args) {
        System.out.println(buildMaxHuiWen("ccc"));
    }
    public static int buildMaxHuiWen(String s){
        int result = 0;
        // 统计每个字符串出现的次数，出现单次的只能选一个，出现双次的都可以选
        Map<Character,Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++){
            char temp = s.charAt(i);
            if(map.containsKey(temp)){
                map.put(temp,map.get(temp)+1);
            }else{
                map.put(temp,1);
            }
        }

        // 求出每个出现的次数
        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            if( next.getValue()%2==0){
                result +=next.getValue();
            }else {
                // 只有一个奇数次数的作为回文中心
                if(result %2 ==0){
                    result +=1;
                }
                result += next.getValue()/2 * 2 ;
            }

        }
        return  result;
    }
}
