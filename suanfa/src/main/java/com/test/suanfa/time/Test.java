package com.test.suanfa.time;

import java.util.Scanner;

/**
 * @auther :
 * @Description:  求字符串 中 最长子串
 * @Date: create in 2020/6/20 20:01
 */
public class Test {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int length = str.length();
        int result = 0;
        //判断 是否全部为数字
        if (str.matches("[A-Z]")) {
            result = -1;
            //判断是否全部为字母
        } else if (str.matches("[0-9]")) {
            result = -1;
        } else {  //当不全为字母和数字的时候
            int temp = 0; //临时变量去存距离
            for (int i = 0; i < length; i++) {
                //找到第一个数字求其后第一个字母
                char c = str.charAt(i);
                //判断此时是否是一个数字
                //当时数字的时候执行下面的循环，不是直接跳出

                //从当前位置一个数字找其后第一个字母
                for (int j = i + 1; j < length; j++) {
                    // 计算两者之间的距离，并保存到一个变量中
                    //判断是否是一个字母
                    char d = str.charAt(j);
                    //如果是跳出循环
                    /**
                     if(是字母)｛
                         temp = j-i；
                         break;
                     ｝
                     */
                }
            }
            System.out.println(result);
        }
    }
}
