package com.east.demo.other.algorithm.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列问题
 * 输入一个整数数组，其中不包含重复元素，返回所有可能的排列。
 *
 * @author: east
 * @date: 2023/12/27
 */
public class AllFormat {
    public void backtrace(List<String> state, List<String> choices, List<List<String>> res) {
        // 结果判断
        if (isSolution(state)) {
            // 记录结果
            recordSolution(state, res);
            return;
        }

        // 所有可能.
        for (String choice : choices) {
            // 剪枝,不出现重复元素
            if (isValid(state, choice)) {
                // 更新状态
                updateState(state, choice);
                // 递归
                backtrace(state, choices, res);
                // 回退
                undoChoice(state, choice);
            }
        }
    }

    private void undoChoice(List<String> state, String choice) {
        state.remove(state.size() - 1);
    }

    private void updateState(List<String> state, String choice) {
        state.add(choice);
    }

    /**
     * @param state  情形
     * @param choice 选择
     * @return 是否合法
     */
    private boolean isValid(List<String> state, String choice) {
        return !state.contains(choice);
    }

    private void recordSolution(List<String> state, List<List<String>> res) {
        ArrayList<String> list = new ArrayList<>(state);
        res.add(list);
    }

    private boolean isSolution(List<String> state) {
        return state.size() == 3;
    }


    /**
     * 回溯基本模型
     * 自己的公式
     * 全排列——>回溯->N叉树
     * 基本模型->全排列
     *
     * @return
     */
    public List<String> allFormat() {
        String[] array = {"1", "2", "3"};
        ArrayList<String> res = new ArrayList<>();
        mybacktrace(array, res, "");
        return res;
    }

    // private String temp="";
    public void mybacktrace(String[] array, List<String> res, String temp) {
        // 是否是解 :长度满足且没已经存在
        if (temp.length() == array.length) {
            res.add(temp);
            return;
        }


        // N叉遍历
        for (int j = 0; j < array.length; j++) {
            // 是否可剪枝: 不能包含自己（每个元素只能选一次)
            if (temp.contains(array[j])) {
                continue;
            }

            temp = temp + array[j];

            // 继续递归
            mybacktrace(array, res, temp);
            // 回溯
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        AllFormat allFormat = new AllFormat();
        // ArrayList<String> state = new ArrayList<>();
        // List<String> choices = Arrays.asList("1", "2", "3", "4", "5");
        // ArrayList<List<String>> res = new ArrayList<>();
        // allFormat.backtrace(state, choices, res);
        // System.out.println(res.size());

        List<String> strings = allFormat.allFormat();
        System.out.println(strings.toString());

    }

}
