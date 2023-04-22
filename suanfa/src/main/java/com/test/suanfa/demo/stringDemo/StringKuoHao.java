package com.test.suanfa.demo.stringDemo;

import java.util.Stack;

public class StringKuoHao {
    public static void main(String[] args) {
        String str = "{}{(}(())";
        System.out.println(checkStr(str));
    }

    /**
     * 思路2：进行成对的字符串替换
     */
    public static boolean checkStr(String str){
        if ((str.length() & 1) == 1) {
            return false;
        }
        while (str.contains("()") || str.contains("[]") || str.contains("{}")) {
            str = str.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return str.equals("");
    }

    /**
     *  思路： 如果遇到左边就进行压栈，如果是右边就弹出判断是否匹配成对
     */
    public static boolean checkStr2(String s){
        if(s.length() % 2 !=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i< s.length();i++){
            char str = s.charAt(i);
            // 左边的压入栈
            if(str == '{'|| str == '['|| str == '(' ){
                stack.push(str);
                // 右边判断是否有成对，不是左半不成对，如果栈是空不匹配，
            }else if(stack.isEmpty() || str == ')' && stack.pop()!='(' || str == '}'&& stack.pop()!='{' || str == ']' && stack.pop() !='[' ){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
