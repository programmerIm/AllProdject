package com.test.suanfa.demo.stringDemo;


/**
 * 最长回文子序列，在不改变顺序或者删除某些字符的前提下
 * @author liming522
 * @date 2023/3/1 10:10
 */
public class MaxHuiWenSub {
    public static void main(String[] args) {
        String str = "bbbab";
        System.out.println(getMaxHuiWenSub(str));
    }

    private static int getMaxHuiWenSub(String str) {
        /**
         * 求最长的回文子序列
         *  当 只有一个元素的时候其也是回文子序列
         * 利用动态规划的解法
         * dp[i][j] 代表i到j之间的最长回文子序列的长度
         * 如果 i=j 即 dp[i][i] = 1
         */
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int i =n-1;i>=0;i--){
            dp[i][i]=1;
            char c1 = str.charAt(i);
            for (int j = i+1;j<n;j++){
                char c2 = str.charAt(j);
                if(c1==c2){
                    // 此时不对的原因是因为 i+1还不知道呢
                    dp[i][j]=dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
         return  dp[0][n-1];
    }
}
