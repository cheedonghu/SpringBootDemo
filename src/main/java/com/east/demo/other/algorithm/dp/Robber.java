package com.east.demo.other.algorithm.dp;

/**
 * 打家劫舍
 *
 * @author: east
 * @date: 2026/5/11 19:09
 */
public class Robber {

    /**
     * 你是一个经验丰富的小偷，准备偷沿街的一排房间，每个房间都存有一定的现金，为了防止被发现，你不能偷相邻的两家，即，如果偷了第一家，就不能再偷第二家；如果偷了第二家，那么就不能偷第一家和第三家。
     * 给定一个整数数组nums，数组中的元素表示每个房间存有的现金数额，请你计算在不被发现的前提下最多的偷窃金额。
     * <p>
     * 状态转移方程：对于当前这家dp[i]，若上一家偷了，则此时不能偷等于dp[i-1] 若上一家没偷，这家能偷此时等于dp[i-2]+val[i]
     * dp[i]=max(dp[i-1],dp[i-2]+val)
     */
    public int rob(int[] nums) {
        // write code here
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 2] + nums[i];
        }
        int max = dp[nums.length - 1];
        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];
        for (int i = 2; i < dp2.length; i++) {
            dp2[i] = dp2[i - 2] + nums[i];
        }
        return Math.max(max, dp2[dp2.length - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Robber robber = new Robber();
        System.out.println(robber.rob(nums));
    }
}
