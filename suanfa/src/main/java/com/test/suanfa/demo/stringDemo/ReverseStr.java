package com.test.suanfa.demo.stringDemo;

/**
 *  反转字符串
 * @author liming522
 * @date 2023/4/21 1:36
 */
public class ReverseStr {
    public static void main(String[] args) {
       String str= "abc";
        System.out.println(reverse(str));
    }

    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1) {
            return originStr;
        }
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }




}
