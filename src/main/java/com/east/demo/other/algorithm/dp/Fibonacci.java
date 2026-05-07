package com.east.demo.other.algorithm.dp;

import java.util.Arrays;

/**
 *
 * @author: east
 * @date: 2026/5/5 15:39
 */
public class Fibonacci {

    /**
     * 空间优化：->不用dp表，用变量替代状态转移方程元素
     */
    public int fibonacci3(int n) {
        // write code here

        int a = 1, b = 1;
        int res = 0;

        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }

        return res;
    }

    /**
     * dp解法
     * 状态转移方程dp[n]=dp[n-1]+dp[n-2]
     * 初始状态: dp1=1,dp2=1
     * dp[n]代表值为n时的问题对应子问题的解
     *
     */
    public int fibonacci2(int n) {
        // write code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    private int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacci3(5));
    }
}
