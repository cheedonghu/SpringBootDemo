package com.east.demo.other.algorithm.dp;

/**
 * 岛屿搜索
 *
 * @author: east
 * @date: 2024/4/10
 */
public class IslandSearch {
    public static void main(String[] args) {
        char[][] chars = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(chars));
    }

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 符合岛屿要求开始拓展
                if (grid[i][j] == '1' && !visit[i][j]) {
                    search(grid, visit, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void search(char[][] grid, boolean[][] visit, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == '0') {
            return;
        }

        if (grid[i][j] == '1' && !visit[i][j]) {
            visit[i][j] = true;
            search(grid, visit, i + 1, j);
            search(grid, visit, i, j + 1);
            if (i >= 1) {
                search(grid, visit, i - 1, j);
            }
            if (j >= 1) {
                search(grid, visit, i, j - 1);
            }
        }
    }
}
