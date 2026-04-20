package com.east.demo.other.algorithm.backtrace.list;

import java.util.Arrays;

/**
 * 岛屿数量问题
 *
 * @author: east
 * @date: 2026/4/16 16:08
 */
public class IslandNumber {
    /**
     * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
     * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
     * 例如：
     * 输入
     * [
     * [1,1,0,0,0],
     * [0,1,0,1,1],
     * [0,0,0,1,1],
     * [0,0,0,0,0],
     * [0,0,1,1,1]
     * ]
     * 对应的输出为3
     * <p>
     * <p>
     * 寻找，回退->dfs
     * <p>
     * 普通dfs思路
     * 用visitmap，每个为0的都作为起始找一遍
     * 找到边界||值为0 return
     * <p>
     * dfs(右)
     * dfs(下)
     * dfs(左)
     * dfs(上)
     * <p>
     * if(hasIsland) res++;
     *
     * @param grid
     * @return
     */
    private int result = 0;
    private int find = 0;

    public int solve(char[][] grid) {
        if (grid == null) return 0;
        // write code here
        int[][] visit = new int[grid.length][grid[0].length];
        for (int i = 0; i < visit.length; i++) {
            Arrays.fill(visit[i], 0);
        }


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                backtrace(grid, visit, i, j);
                if (find > 0) {

                    find = 0;
                }
            }
        }
        return result;
    }

    private void backtrace(char[][] grid, int[][] visit, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visit[i][j] == 1) {
            return;
        }

        visit[i][j] = 1;
        backtrace(grid, visit, i + 1, j);
        backtrace(grid, visit, i, j + 1);
        backtrace(grid, visit, i - 1, j);
        backtrace(grid, visit, i, j - 1);

        find += 1;

    }

    public static void main(String[] args) {
        // char[][] grid = {
        //         {'1', '1', '0','0','0'},
        //         {'0', '1', '0','1','1'},
        //         {'0', '0', '0','1','1'},
        //         {'0', '0', '0','0','0'},
        //         {'0', '0', '1','1','1'}
        // };

        char[][] grid = {
                {'1'},
                {'0'},
                {'0'},
                {'0'},
                {'0'},
                {'1'},
                {'1'},
                {'0'},
                {'0'},
                {'1'},
                {'0'},
                {'0'}
        };

        IslandNumber islandNumber = new IslandNumber();
        System.out.println(islandNumber.solve(grid));
    }
}
