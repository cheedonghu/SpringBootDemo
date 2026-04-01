package com.east.demo.other.algorithm.backtrace.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: east
 * @date: 2024/1/18
 */

public class GetHappyString1415 {
    public static void main(String[] args) {
        GetHappyString1415 getHappyString1415 = new GetHappyString1415();
        System.out.println(getHappyString1415.getHappyString(3, 9));
    }

    /**
     * leetcode: 1415
     * 全排列问题 -> 回溯
     * 貌似也和dp有点关系？
     *
     * @param n 字符个数
     * @param k （第几个）下标
     * @return 结果
     */
    public String getHappyString(int n, int k) {
        ArrayList<String> res = new ArrayList<>();
        backtrace(res, new ArrayList<>(), Arrays.asList('a', 'b', 'c'), n);

        res.sort(String::compareTo);

        if (k > res.size()) {
            return "";
        }
        return res.get(k - 1);
    }

    public void backtrace(List<String> res, List<Character> state, List<Character> choices, Integer n) {
        if (isSolution(state, n)) {
            recordSolution(res, state);
        }

        for (Character choice : choices) {
            if (isValid(state, choice, n)) {
                updateState(state, choice);
                backtrace(res, state, choices, n);
                undoChoice(state);
            }
        }
    }

    private void undoChoice(List<Character> state) {
        state.remove(state.size() - 1);
    }

    private void updateState(List<Character> state, Character choice) {
        state.add(choice);
    }

    /**
     * 判断是否合法：
     * 1. state长度+1不能超过n
     * 2. state的最后一个字母不能和choice相同
     */
    private boolean isValid(List<Character> state, Character choice, Integer n) {
        if (state.isEmpty()) {
            return true;
        }
        boolean judge1 = state.size() + 1 <= n;
        boolean judge2 = !state.get(state.size() - 1).equals(choice);
        return judge1 && judge2;
    }

    private void recordSolution(List<String> res, List<Character> state) {
        String happyString = state.stream().map(String::valueOf).collect(Collectors.joining());
        res.add(happyString);
    }

    /**
     * 判断是否是happy string：
     * 要题目要求state长度为n即可
     */
    private boolean isSolution(List<Character> state, Integer n) {
        return state.size() == n;
    }


}
