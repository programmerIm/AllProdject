package com.test.suanfa.demo.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CubeRoot {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        double num = Double.valueOf(bf.readLine());
        double x = Dichotomy(num);
        System.out.printf("%.1f", x);
    }

    //使用类似二分的思路
    public static double Dichotomy(double num) {
        double right, left, mid = 0.0;
        //一定要注意边界条件，输入的num可能是负数  将x<-1的边界范围定为[x,1]，x>1的边界范围定为[-1,x]
        right = Math.max(1.0, num);
        left = Math.min(-1.0, num);
        while (right - left > 0.001) {
            mid = (left + right) / 2;
            //如果乘积大于num，说明立方根在mid的左侧
            if (mid * mid * mid > num) {
                right = mid;
            }
            //如果乘积小于num，说明立方根在mid的右侧
            else if (mid * mid * mid < num) {
                left = mid;
            } else {
                return mid;
            }
        }
        return right;
    }
}
