package com.test.suanfa.test;

/**
 * @auther :liming
 * @Description:
 * @Date: create in 2020/4/29 21:56
 */
public class Test {
    public static void main(String[] args) {
        int i1 = 10;
        i1++;
        System.out.println(i1);

        int i2 = 10;
        i2++;
        System.out.println(i2);

        int i3 = 10;
        int i4 = i3++;
        System.out.println(i4);

        int i5 = 10;
        int i6 = ++i5;
        System.out.println(i6);

        int i7 = 10;
         i7= ++i7;
        System.out.println(i7); //11

        int i8 = 10;
         i8 = i8++;
        System.out.println(i8); //10

        int i9 = 10;
        int i10 = i9++ + ++i9;
        System.out.println(i10); //10+12=22
    }
}
