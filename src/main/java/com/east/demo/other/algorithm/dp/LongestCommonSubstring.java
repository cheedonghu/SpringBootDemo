package com.east.demo.other.algorithm.dp;

/**
 * 最长公共子串
 *
 * @author: east
 * @date: 2026/5/5 17:59
 */
public class LongestCommonSubstring {
    /**
     * 解决办法：专门算法
     * 将s1和s2制表，计算dp表格
     * dp[i][j]= s[i]==s[j]? s[i-1][j-1]+1 : 0
     * <p>
     * 搞两个变量
     * 一个保存最大长度，一个保存最大下标（i，j都行）
     * 结果就从最大下标那里倒退就行
     *
     */
    public String lcs(String s1, String s2) {
        // write code here
        return null;
    }

    public static void main(String[] args) {
        LongestCommonSubstring longestCommonSequence = new LongestCommonSubstring();
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23A456A";
        System.out.println(longestCommonSequence.lcs(s1, s2));
    }
}
