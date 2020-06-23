package com.test.suanfa.demo.jumpStep;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @auther :
 * @Description:
 * @Date: create in 2020/6/20 20:56
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int high   = sc.nextInt();//小明的身高
        int  classNum = sc.nextInt();//班级的人数
        //当身高有问题
        if(high<=0||high>=200){
            return;
        }
        //当班级人数有问题
        if(classNum<=0||classNum>=50){
            return;
        }
        //将所有同学顺序用数组接收
        int[] allStudents = new int[classNum];
        for(int i =0;i<classNum;i++){
            allStudents[i] = sc.nextInt();
        }

        //再定义一个数组存放身高差

        int[]  studentHigh = new int[classNum]; //身高差
        for(int i =0;i<allStudents.length;i++){
           int  cha = high -allStudents[i];
            if(cha <0){
                studentHigh[i] = allStudents[i] - high;
            }else {
                studentHigh[i] = cha;
            }
        }

        //将身高差数组进行排序，选择一个稳定的排序算法
       for(int j =0;j<studentHigh.length;j++){
            for(int y =0;y<studentHigh.length-1-j;y++) {
                if (studentHigh[y] > studentHigh[y + 1]) {
                    int temp = studentHigh[y];
                    studentHigh[y] = studentHigh[y+1];
                    studentHigh[y+1]  =  temp;
                }
            }
        }

        String result = "";
        for(int i=0;i<studentHigh.length;i++){
            result += studentHigh[i]+" ";
        }
        System.out.println(result);
    }
}
