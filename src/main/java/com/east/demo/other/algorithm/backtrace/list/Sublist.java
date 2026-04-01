package com.east.demo.other.algorithm.backtrace.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 子集问题
 *
 * @author: east
 * @date: 2023/12/28
 */
public class Sublist {
    /**
     * 给定一个正整数数组 nums 和一个目标正整数 target ，请找出所有可能的组合，使得组合中的元素和等于 target 。
     * 给定数组无重复元素，每个元素可以被选取多次。请以列表形式返回这些组合，列表中不应包含重复组合。
     */
    public void targetList() {
        List<Integer> nums = Arrays.asList(4, 3, 8, 5, 7, 6);
//        nums.sort((o1, o2) -> o1<o2?1:0);  //不需要排序，全排列本来就包含所有可能。
        int target = 30;
        List<Integer> state = new ArrayList<>();
        ArrayList<List<Integer>> res = new ArrayList<>();
        backtrace(state, nums, res, target);
        for (List<Integer> list : res) {
            list.forEach(System.out::print);
            System.out.print(",\t");
        }
        System.out.println();
        System.out.println("总数：" + res.size());
    }

    private void backtrace(List<Integer> state, List<Integer> choices, ArrayList<List<Integer>> res, Integer target) {
        if (isSolution(state, target)) {
            recordSolution(state, res);
            return;
        }

        for (Integer num : choices) {
            if (isValid(state, num, res, target)) {
                updateState(state, num);
                backtrace(state, choices, res, target);
                undoChoice(state);
            }
        }
    }

    private void undoChoice(List<Integer> state) {
        state.remove(state.size() - 1);
    }

    private void updateState(List<Integer> state, Integer choice) {
        state.add(choice);
    }

    private boolean isValid(List<Integer> state, Integer choice, ArrayList<List<Integer>> res, Integer target) {
        // 剪枝：
        // 1. 元素和小于target
        // 2. 要求无重复组合。 分析一下：这里因为是纯正数，所以如果当前状态被包含在了结果集里面则说明不用继续下去了，再加元素也只会更大
        // 怎么判断呢？ 强制让元素按照从小到大顺序排列(这里就也要求原数组有序,不需要！全排列包含所有情况，顺序无所谓),
        // 然后用res判断包含关系就行（可能要重写equals,不用 Integer重写了equals
        Optional<Integer> sumOptional = state.stream().reduce(Integer::sum);
        Integer sum = sumOptional.isPresent() ? sumOptional.get() : 0;
        boolean judgeSum = sum < target;

        boolean judgeSort = state.isEmpty() ? true : choice >= state.get(state.size() - 1);

        boolean judgeIdentical = !res.contains(state);

        return judgeSum && judgeSort && judgeIdentical;
    }

    private void recordSolution(List<Integer> state, ArrayList<List<Integer>> res) {
        res.add(new ArrayList<>(state));
    }

    private boolean isSolution(List<Integer> state, Integer target) {
        // 数组元素和为9
        Optional<Integer> reduce = state.stream().reduce(Integer::sum);
        return reduce.isPresent() && target.equals(reduce.get());
    }

    public static void main(String[] args) {
        Sublist sublist = new Sublist();
        sublist.targetList();
    }
}
