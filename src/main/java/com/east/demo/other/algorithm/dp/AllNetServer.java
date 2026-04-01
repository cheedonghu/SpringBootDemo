package com.east.demo.other.algorithm.dp;

/**
 * 可以组成网络的服务器(华为OD)
 *
 * @author: east
 * @date: 2024/3/16 14:07
 */

public class AllNetServer {
    /**
     * 在一个机房中，服务器的位置标识在n*m的整数矩阵网格中，1表示单元格上有服务器，0表示没有。
     * 如果两台服务器位于同一行或者同一列中紧邻的位置，则认为它们之间可以组成一个局域网，请你统计机房中最大的局域网包含的服务器个数。
     *
     * 采用回溯解决，关键在于，choices怎么使用，for(int i=0;i<4;i++)代表的四种可能不好处理，这里直接转化成
     * dfs(...,i-1,j);
     * dfs(...,i+1,j);
     * dfs(...,i,j-1);
     * dfs(...,i,j+1);
     */


}
