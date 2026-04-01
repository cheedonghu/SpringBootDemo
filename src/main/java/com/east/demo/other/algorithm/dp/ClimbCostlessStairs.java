package com.east.demo.other.algorithm.dp;

/**
 * 爬楼梯最小代价
 * 给定一个楼梯，你每步可以上 1 阶或者 2 阶，每一阶楼梯上都贴有一个非负整数，表示你在该台阶所需要付出的代价。
 * 给定一个非负整数数组 cost ，其中 cost[i] 表示在第 i 个台阶需要付出的代价，cost[0]为地面（起始点）。
 * 请计算最少需要付出多少代价才能到达顶部？
 *
 * @author: east
 * @date: 2024/1/10
 */
public class ClimbCostlessStairs {

    /**
     * dp[i] 只能由dp[i-1]或dp[i-2]过来，因此代价为cost[i-1]+i或cost[i-2]+i
     * 所以最优解为min(dp[i-1],dp[i-2])+i
     *
     * @param n     阶
     * @param costs 代价
     * @return res
     */
    public int dp(int n, int[] costs) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp_minCost = new int[n + 1];
        dp_minCost[1] = costs[1];
        dp_minCost[2] = costs[2];
        for (int i = 3; i < n + 1; i++) {
            dp_minCost[i] = Math.min(dp_minCost[i - 1], dp_minCost[i - 2]) + costs[i];
        }
        return dp_minCost[n];
    }

    public static void main(String[] args) {
        ClimbCostlessStairs climbCostlessStairs = new ClimbCostlessStairs();
        int n = 3;
        int[] costs = new int[n + 1];
        costs[1] = 1;
        costs[2] = 10;
        costs[3] = 1;
        int minCost = climbCostlessStairs.dp(n, costs);
        System.out.println("最小代价为：" + minCost);
    }
}
