package com.east.demo.other.algorithm.dp;

/**
 * 爬有限制的楼梯
 * 给定一个共有n阶的楼梯，你每步可以上1阶或者2阶，但不能连续两轮跳1阶，请问有多少种方案可以爬到楼顶？
 *
 * @author: east
 * @date: 2024/1/10
 */
public class ClimbRefrainStairs {


    /**
     * 如果没有限制，第i阶仅仅由当前阶数决定，然而有限制后则与之前的状态有关，如果上一阶是由跳1阶上来的，则本次不能选择跳1阶
     * 因此在原来的dp[i]基础上要加上额外条件dp[i,1]和dp[i,2]表示阶梯i的两种不同攀爬情况
     * dp[i,1]=dp[i-1,2]
     * dp[i,2]=dp[i-1,1]+dp[i-1,2]
     * dp[i]=dp[i,1]+dp[i,2]
     *
     * @param n 阶数
     * @return res
     */
    public int dp(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[][] dp = new int[n + 1][3];
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[2][1] = 0;
        dp[2][2] = 1;

        for (int i = 3; i < n; i++) {
            dp[i][1] = dp[i - 1][2];
            dp[i][2] = dp[i - 1][1] + dp[i - 1][2];
        }
        int count = dp[n][1] + dp[n][2];
        return count;
    }
}
