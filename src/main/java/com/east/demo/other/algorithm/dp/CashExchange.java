package com.east.demo.other.algorithm.dp;

/**
 * 零钱兑换问题
 *
 * @author: east
 * @date: 2024/1/12
 */
public class CashExchange {

    /**
     * 给定n种硬币，第i种硬币的面值为coin[i]，目标金额为amt，每种硬币可以重复选取，问能够凑出目标金额的最少硬币数量。
     * 如果无法凑出目标金额，则返回-1。
     * 可穷举，最少：动态规划 。换个问法：对于金额1->amt，给出每种金额所需最少硬币数量
     * <p>
     * 状态定义dp[i][j]，其中i表示第i种硬币，j表示目标金额，dp代表硬币数量, 然后i\amt进行填表
     * <p>
     * 这里需要注意边界条件：第一层要特别初始化，如果不能整除则-1
     * dp[i][j] =   -1, j<
     * min(dp[i][j-coin[i]]+1, dp[i-1][j])
     *
     * @param coins  面值
     * @param amount 目标金额
     */
    public int exchange1(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int n = coins.length - 1;
        int[][] dp = new int[n + 1][amount + 1];

        // dp[0][*], dp[*][0]=0
        for (int i = 0; i < dp.length; i++) {
            dp[0][i] = -1;
            dp[i][0] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (i == 1) {
                    // 如果目标j金额不能整除第一个金额则赋值-1
                    dp[i][j] = j % coins[i] == 0 ? j / coins[i] : -1;
                } else if (j - coins[i] >= 0) {
                    dp[i][j] = Math.min(dp[i][j - coins[i]] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    /**
     * 给定n种硬币，第n种面值为coins[n]，目标金额为amt，每种硬币可以重复选取，问凑出目标金额的硬币组合数量
     * 换个问法： 求出0->amt中每个金额有多少种组合-> dp[i][j]含义: i个硬币，凑出j金额有dp[i][j]种可能
     * <p>
     * 分析：当前状态的组合数量等于不选当前硬币dp[i-1][j]与选当前硬币dp[i][]这两种决策的组合数量之和
     * <p>
     * dp[i][j] = 1, j=0
     * = dp[i][j-coin[i]] + dp[i-1][j], 且j>=coin[i]
     * = dp[i-1][j], j<coin[i]
     * <p>
     * 另一个思路：
     */
    public int exchange2(int[] coins, int amount) {
        int n = coins.length - 1;
        int[][] dp = new int[n + 1][amount + 1];

        // dp[i][j] = 1, j=0
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[0][i] = 0;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[i][j] = dp[i][j - coins[i]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount];
    }

    /**
     * 空间优化版本；硬币选与不选只是选择，目标金额全量统计(0->amount/j)才是关键，所以维度i去掉
     *
     * @param coins
     * @param amount
     * @return
     */
    public int exchange2Improved(int[] coins, int amount) {
        int n = coins.length - 1;
        // j/amount才是关键的
        int[] dp = new int[amount + 1];

        // 目标金额为0时初始化为1
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[j] = dp[j] + dp[j - coins[i]];
                } else {
                    // 不选择硬币i
                    dp[j] = dp[j];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CashExchange cashExchange = new CashExchange();
        int[] coins = {0, 1, 2, 5};
        int amt = 5;


//        int count = cashExchange.exchange1(coins, amt);
//        System.out.println("最小数量为："+count);

        int count = cashExchange.exchange2(coins, amt);
        int count2 = cashExchange.exchange2Improved(coins, amt);
        System.out.println("硬币组合数量为" + count2);

    }
}
