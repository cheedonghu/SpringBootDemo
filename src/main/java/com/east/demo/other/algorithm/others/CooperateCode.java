package com.east.demo.other.algorithm.others;

/**
 * 结对编程
 *
 * @author: east
 * @date: 2024/3/9 21:01
 */

public class CooperateCode {
    /**
     * 某部门计划通过结队编程来进行项目开发，已知该部门有 N 名员工，每个员工有独一无二的职级，每三个员工形成一个小组进行结队编程，
     * 结队分组规则如下: 从部门中选出序号分别为 i、j、k 的3名员工，他们的职级分别为 leve[i]，level[j]，level[k],
     * 结队小组满足 level[i] < level[j] < level[k] 或者 level[i] > level[j] > level[k],其中0<i<j<k<n。
     * 请你按上述条件计算可能组合的小组数量。同一员工可以参加多个小组. 给出Java详细代码
     * <p>
     * 为了解决这个问题，我们可以遍历所有可能的三人组合，并检查他们是否满足给定的职级条件。但这种方法的时间复杂度会很高，特别是当员工数目很多时。
     * <p>
     * 一个更高效的方法是，对于每个员工，分别计算在其左侧和右侧满足职级条件的员工数。具体来说，对于第i个员工，我们需要计算：
     * <p>
     * 在其左侧有多少员工的职级低于level[i]（记为leftLower），以及有多少员工的职级高于level[i]（记为leftHigher）。
     * 在其右侧有多少员工的职级低于level[i]（记为rightLower），以及有多少员工的职级高于level[i]（记为rightHigher）。
     * 对于每个员工i，满足level[i] < level[j] < level[k]的组合数为leftLower * rightHigher，
     * 满足level[i] > level[j] > level[k]的组合数为leftHigher * rightLower。
     * 我们可以遍历每个员工，累加这些组合数得到总的可能组合数。
     */

    public static int countTeams(int[] level) {
        int n = level.length;
        int count = 0;

        // 遍历每个员工作为中间员工的情况
        for (int j = 1; j < n - 1; j++) {
            int leftLower = 0, leftHigher = 0, rightLower = 0, rightHigher = 0;

            // 计算左侧满足条件的员工数
            for (int i = 0; i < j; i++) {
                if (level[i] < level[j]) leftLower++;
                else if (level[i] > level[j]) leftHigher++;
            }

            // 计算右侧满足条件的员工数
            for (int k = j + 1; k < n; k++) {
                if (level[k] < level[j]) rightLower++;
                else if (level[k] > level[j]) rightHigher++;
            }

            // 计算组合数并累加
            count += leftLower * rightHigher + leftHigher * rightLower;
        }

        return count;
    }

}
