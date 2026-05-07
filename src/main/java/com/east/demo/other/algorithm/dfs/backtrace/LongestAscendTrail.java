package com.east.demo.other.algorithm.dfs.backtrace;

import java.util.Arrays;

/**
 *
 * @author: east
 * @date: 2026/5/6 10:24
 */
public class LongestAscendTrail {
    /**
     * 矩阵最长递增路径！
     * <p>
     * 给定一个 n 行 m 列矩阵 matrix ，矩阵内所有数均为非负整数。
     * 你需要在矩阵中找到一条最长路径，使这条路径上的元素是递增的。并输出这条最长路径的长度。
     * 这个路径必须满足以下条件： 1. 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外。
     * 2. 你不能走重复的单元格。即每个格子最多只能走一次。
     * 数据范围： 1 ≤ n , m ≤ 1000  0≤matrix[i][j]≤1000
     * 进阶：空间复杂度O(nm) ，时间复杂度O(nm)
     * <p>
     * 上下左右->base（岛屿问题!!!），n叉树问题
     * <p>
     * dfs(matrix,i,j)
     * i,j越界 return
     * 当前状态+1
     * 判断当前状态是否是最大
     * 能递增且未到达 dfs
     * 能递增且未到达 dfs
     * 能递增且未到达 dfs
     * 能递增且未到达 dfs
     * <p>
     * 有当前状态，且当前状态会undo->backtrace
     * isSolution明确，state>max->max=state->backtrace
     * for choice不明确?，还是用dfs算了
     * backtrace适合每次都从头找，dfs适合每次从上次开始地方开始找？
     */
    int state = 0;
    int result = 0;

    public int solve(int[][] matrix) {
        // write code here
        if (matrix.length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visit = new int[m][n];
        for (int i = 0; i < visit.length; i++) {
            Arrays.fill(visit[i], 0);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(matrix, visit, -1, i, j);
            }
        }
        return result;

    }

    private void dfs(int[][] matrix, int[][] visit, int before, int i, int j) {
        // 是否合法
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || visit[i][j] == 1) {
            return;
        }

        // 不是递增
        if (before >= matrix[i][j]) {
            return;
        }

        visit[i][j] = 1;
        state++;
        before = matrix[i][j];

        if (state > result) {
            result = state;
        }

        // 上
        dfs(matrix, visit, before, i - 1, j);
        // 下
        dfs(matrix, visit, before, i + 1, j);
        // 左
        dfs(matrix, visit, before, i, j - 1);
        // 右
        dfs(matrix, visit, before, i, j + 1);

        state--;
        visit[i][j] = 0;

    }

    public static void main(String[] args) {
        LongestAscendTrail longestAscendTrail = new LongestAscendTrail();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(longestAscendTrail.solve(matrix));
    }
}
