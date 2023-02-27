package com.test.suanfa.demo.math;

/**
 *
 * @author liming522
 * @date 2023/2/27 10:11
 *   统计二进制数中有几个1
 * @return null
 */
public class HaveOne {

    public static void main(String[] args) {
        System.out.println(test(7));
    }

    private static int test(int i) {
        int count = 0;
        while (i!=0){
            i = i & (i-1);
            ++count;
        }
        return  count;
    }
}
