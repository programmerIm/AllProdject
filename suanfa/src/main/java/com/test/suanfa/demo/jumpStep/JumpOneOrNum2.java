package com.test.suanfa.demo.jumpStep;

import java.util.Scanner;

/**
 * @auther :liming
 * @Description:  普通跳台阶，一次跳一阶和一次跳三阶的解法
 * @Date: create in 2020/6/21 0:31
 */
public class JumpOneOrNum2 {
    static int N;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner=new Scanner(System.in);
        N=scanner.nextInt(); //N节台阶
        long []dp = new long[N+1];// 除去零那种
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        dp[3]=2;
        for (int i = 4; i <= N; i++) {
            dp[i]=dp[i-1]+dp[i-3];
        }
        System.out.println(dp[N]);
    }
}
