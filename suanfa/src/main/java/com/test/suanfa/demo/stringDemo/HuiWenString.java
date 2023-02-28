package com.test.suanfa.demo.stringDemo;

public class HuiWenString {
    public static void main(String[] args) {
        String str = "abc";

        System.out.println(getHuiWenMax(str));
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
