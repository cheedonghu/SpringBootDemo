package com.east.demo.other.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 爬楼梯问题:
 * 给定一个共有n阶的楼梯，你每步可以上1阶或者2阶，请问有多少种方案可以爬到楼顶？
 *
 * @author: east
 * @date: 2024/1/10
 */
public class ClimbStairs {


    /**
     * 动态规划：
     * 记忆化搜索是一种从顶至底的方法，递归的将大问题分解为小问题，然后通过回溯逐层收集子问题解，从而构建原问题解。
     * 与之相反，动态规划是一种从底至顶的方法：从最小子问题的解开始，迭代的构建更大子问题解，直到得到原问题解。
     * 因此无需递归，只需循环
     */
    public int dp(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 优化后的dfs搜索：记忆化搜索
     * 原来的dfs搜索会重复计算，例如dfs[5]=dfs[4]+dfs[3]，其中dfs[3]既在这里计算也在dfs[4]=dfs[3]+dfs[2]处出现
     *
     * @param i       当前阶梯
     * @param choices 已计算的
     * @return res
     */
    public int improvedDfs(int i, int[] choices) {
        if (i == 1 || i == 2) {
            return i;
        }
        // 已经在choices内记录，直接返回
        if (choices[i] != -1) {
            return choices[i];
        }

        int count = improvedDfs(i - 1, choices) + improvedDfs(i - 2, choices);
        choices[i] = count;
        return count;
    }

    /**
     * 分析后的dfs搜索算法： 暴力搜索
     * 因为每次只能上1或2阶，所以踩在当前位置i，上一步只可能是i-1或者i-2阶的位置，
     * 所以到i的方法数等于i-1方法数加i-2方法数
     * DP[i]=DP[i-1] + DP[i-2]
     */
    public int dfs(int i) {
        // DP[1]和DP[2]已知
        if (i == 1 || i == 2) {
            return i;
        }

        // DP[i] = DP[i-1] + DP[i-2]
        return dfs(i - 1) + dfs(i - 2);
    }

    /**
     * 普通回溯算法
     *
     * @param state state
     * @param n     总台阶数
     * @param res   res
     */
    public void backtrace(List<Integer> state, Integer n, List<List<Integer>> res) {
        if (isSolution(state, n)) {
            recordSolution(state, res);
            return;
        }

        for (int step = 1; step < 3; step++) {
            if (isValid(state, step, n)) {
                updateState(state, step);
                backtrace(state, n, res);
                undoChoice(state);
            }
        }
    }

    private void undoChoice(List<Integer> state) {
        state.remove(state.size() - 1);
    }

    private void updateState(List<Integer> state, int step) {
        state.add(step);
    }

    private boolean isValid(List<Integer> state, int step, Integer n) {
        int sum = 0;
        for (int i = 0; i < state.size(); i++) {
            sum += state.get(i);
        }
        return n >= (sum + step);
    }

    private void recordSolution(List<Integer> state, List<List<Integer>> res) {
        res.add(new ArrayList<>(state));
    }

    private boolean isSolution(List<Integer> state, Integer n) {
        int sum = 0;
        for (int i = 0; i < state.size(); i++) {
            sum += state.get(i);
        }
        return sum == n;
    }

    public static void main(String[] args) {
        int n = 5555;
        ClimbStairs climbStairs = new ClimbStairs();

        // 1. 普通回溯解法
//        List<List<Integer>> res = new ArrayList<>();
//        climbStairs.backtrace(new ArrayList<>(),n, res);
//        System.out.println("共"+res.size()+"种结果");
//        for (List<Integer> re : res) {
//            for (Integer i : re) {
//                System.out.print(i+"\t");
//            }
//            System.out.println();
//        }

        // 2. 问题分析后解法: dfs暴力搜索
//        int count = climbStairs.dfs(n);
//        System.out.println("共"+count+"种结果");

        // 3. 优化DP[i]计算规则后解法:记忆化dfs搜索
//        int[] choices = new int[n+1];
//        for (int i = 0; i < choices.length; i++) {
//            if(i==1||i==2){
//                choices[i]=i;
//            }else{
//                choices[i]=-1;
//            }
//        }
//        int count = climbStairs.improvedDfs(n,choices);
//        System.out.println("共"+count+"种结果");

        // 4. 动态规划
        int count = climbStairs.dp(n);
        System.out.println("共" + count + "种结果");

    }
}
