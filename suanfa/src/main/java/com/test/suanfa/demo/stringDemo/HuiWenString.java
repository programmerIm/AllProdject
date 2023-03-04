package com.test.suanfa.demo.stringDemo;

/**
 *
 * @author liming522
 * @date  00:37
 * 求回文子字符串的个数
 */
public class HuiWenString {
    public static void main(String[] args) {
        String str = "abccba";

        System.out.println(getHuiWenMax(str));
        System.out.println(getMaxHuiWenString(str));
    }

    private static int getHuiWenMax(String str) {
        int result = 0;
        // 利用双指针算法,一个从头部，一个从尾部
        for (int i = str.length()-1; i>=0 ;i--){ // 从length开始是因为截取的 左闭右开
            for (int j=0; j<=i;j++){
                String temp = str.substring(j,i+1);
                if(check(temp)){
                    result ++;
                }
            }
        }
        return result;
    }

    // 求最大回文字符串
    private static String getMaxHuiWenString(String str) {
        String result = "";
        // 利用双指针算法,一个从头部，一个从尾部
        for (int i = str.length()-1; i>0 ;i--){ // 从length开始是因为截取的 左闭右开
            for (int j=0; j<i;j++){
                String temp = str.substring(j,i+1);
                if(check(temp)&& temp.length() >= result.length()){
                    result = temp;
                }
            }
        }
        return result;
    }

    private static boolean check(String temp) {
        char[] chars = temp.toCharArray();
        int length = temp.length();
        for (int i =0;i<length-1;i++){
            if(chars[i]!=chars[length-i-1]){
                return  false;
            }
        }
        return true;
    }



}
