package com.test.suanfa.demo.stringDemo;

import java.util.ArrayList;
import java.util.List;

public class Kuohao {

    public static void main(String[] args) {
        generateParenthesis(3);

    }
    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        brackTrace(new char[2*n],0,result);
        return result;
    }

    public static void brackTrace(char[] array,int index,List<String> list){
        if(index == array.length){
            if(vaild(array)){
                list.add(new String(array));
            }
            return;
        }

        array[index] = '(';
        brackTrace(array,index+1,list);
        array[index] = ')';
        brackTrace(array,index+1,list);
    }

    public static boolean vaild(char[] array){
        int temp = 0;
        // 用 temp去记录左边符号与右边符号的差值，当 <0 或者 不等于0时不满足
        for(int i = 0; i< array.length;i++){
            if(array[i] == '('){
                ++temp;
            }else{
                --temp;
            }
            if(temp<0){
                return false;
            }
        }
        return temp==0;
    }

    //------------------------------------------------------------
    // 在一的基础上对于每一步进行判断，减少生成和循环次数
    public List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack2(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack2(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        if (open < max) {
            cur.append('(');
            backtrack2(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack2(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
