package com.east.demo.other.algorithm.dp;

/**
 * 把数字翻译成字符串
 *
 * @author: east
 * @date: 2026/5/12 21:20
 */
public class RenderNumToStr {

    /**
     * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
     * <p>
     * 现在给一串数字，返回有多少种可能的译码结果
     * <p>
     * 输入：
     * "12"
     * 返回值：
     * 2
     * 2种可能的译码结果（”ab” 或”l”）
     * <p>
     * 输入31717126241541717 返回192
     * <p>
     * 问题核心在于当前位置数字是独立解析还是和上一个和一起解析
     * base-> 跳阶梯问题：当前位置是从上一个跳来还是上上个
     * <p>
     * dp[0]=0
     * dp[1]=num[0].toString
     * <p>
     * dp[n]=max(dp[n-1](和上一个组合),dp[n-2]+2(都单干)),num[n-1:n]<=26
     * dp[n]=dp[n-2]+2（只能单干）,num[n-1:n]>26
     * <p>
     * 靠，不对，对于
     * dp[n]：当num[n-1:n]<=26且不等于20，10时，既能独立译码又能组合译码 因此dp[n]=dp[n-1]+dp[n-2]
     * 当num[n-1:n]>26时或20，10时，dp[n]=dp[n-1]+1
     *
     * @param nums
     * @return
     */
    public int solve(String nums) {
        // write code here
        return -1;

    }

    public static void main(String[] args) {
        RenderNumToStr renderNumToStr = new RenderNumToStr();
        System.out.println(renderNumToStr.solve("160"));
    }
}
