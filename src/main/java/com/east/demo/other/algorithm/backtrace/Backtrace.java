package com.east.demo.other.algorithm.backtrace;

import java.util.List;

/**
 * 回溯算法：该算法在搜索解空间时会采用“尝试”与“回退”的策略。
 * 当算法在搜索过程中遇到某个状态无法继续前进或无法得到满足条件的解时，
 * 它会撤销上一步的选择，退回到之前的状态，并尝试其他可能的选择。
 * <p>
 * 核心思想是从一个初始状态出发，暴力搜索所有可能的解决方案，当遇到正确的解则将其记录，
 * 直到找到解或者尝试了所有可能的选择都无法找到解为止。
 * <p>
 * 回溯算法通常采用“深度优先搜索”来遍历解空间。在“二叉树”章节中，我们提到前序、中序和后序遍历都属于深度优先搜索。
 *
 * @author: east
 * @date: 2023/12/25
 */
public class Backtrace {
    /* 回溯算法框架 note: 注意这里方法入参并不是写死的，具体问题具体分析!，分析很重要 */
    void backtrace(State state, List<Choice> choices, List<State> res) {
        if (isSolution(state)) {
            // 记录解
            recordSolution(state, res);
            // 不再继续搜索
            return;
        }
        // 遍历所有选择
        for (Choice choice : choices) {
            // 剪枝: 作出选择，更新状态（note: 注意这里方法入参并不是写死的，具体问题具体分析
            if (isValid(state, choice)) {
                //尝试：作出选择，更新状态
                makeChoice(state, choice);
                backtrace(state, choices, res);
                // 回退：撤销选择，恢复之前状态
                undoChoice(state, choice);
            }
        }
    }

    private void undoChoice(State state, Choice choice) {
    }

    private void makeChoice(State state, Choice choice) {
    }

    private boolean isValid(State state, Choice choice) {
        return true;
    }

    private boolean isSolution(State state) {
        return true;
    }

    private void recordSolution(State state, List<State> res) {
    }

    class State {
    }

    class Choice {
    }

}
