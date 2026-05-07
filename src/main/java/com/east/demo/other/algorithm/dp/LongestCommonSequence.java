package com.east.demo.other.algorithm.dp;

import java.util.Arrays;

/**
 * 最长公共子序列
 *
 * @author: east
 * @date: 2026/5/5 17:59
 */
public class LongestCommonSequence {
    /**
     * 解决办法：专门算法
     * 将s1和s2制表，计算dp表格，取左和上进行赋值
     * dp[i][j]=max(dp[i-1][j],dp[i][j-1])+(s1==s2?1:0)
     * 最后从右下角反推最长路径
     * 当s1和s2字符一致，加入结果集，往左上跳转，若不一致往点数大的跳转，若点数一致网上跳转
     * 返回翻转后的结果集
     *
     */
    public String lcs(String s1, String s2) {
        // write code here
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 0);
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + (s1.charAt(i - 1) == s2.charAt(j - 1) ? 1 : 0);
            }
        }

        // 右下角反推最长公共子序列
        int i = m;
        int j = n;
        if (dp[i][j] == 0) return "-1"; // 无目标子序列
        StringBuilder res = new StringBuilder();
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                // 当字符相等，往左上角跳，加入结果集
                res.append(s1.charAt(i - 1));
                i--;
                j--;
            } else {
                // 往左边或上边值大的方向跳
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else if (dp[i - 1][j] < dp[i][j - 1]) {
                    j--;
                } else {
                    // 值相等时，往上跳
                    i--;
                }
            }
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        LongestCommonSequence longestCommonSequence = new LongestCommonSequence();
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23A456A";
        System.out.println(longestCommonSequence.lcs(s1, s2));
    }
}
