package com.test.suanfa.offer;

/**
 * @auther :liming
 * @Description:
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * @Date: create in 2020/6/23 14:52
 */
public class Test05_StringReplace {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(menthod2(s));
    }

    /**
     * 自己做一个替换字符的函数，比直接使用工具用时短
     * @param s
     * @return
     */
    public static String menthod2(String s){
        int length = s.length();
        char[] chars = new char[length*3];//直接构造一个是容量三倍的
        int index = 0; //新字符数组填充的索引位置
        for(int i =0;i<length;i++){ //遍历每一个字符串
            if(s.charAt(i)==' '){ //当遇到空格时，新创建的字符相应位置就要填充
                chars[index]='%';
                chars[index+1]='2';
                chars[index+2]='0';
                index+=3;
            }else {
                chars[index] = s.charAt(i);
                index+=1;
            }
        }
        String newString = new String(chars,0,index);
        return newString;
    }
    /**
     * 这种方法耗时太长
     * @param s
     * @return
     */
    public static  String method1(String s){
        if(s==null||s.length()>10000||s.length()==0){
            return "";
        }else {
            String newString = s.replaceAll(" ","%20");
           return newString;
        }
    }
}
