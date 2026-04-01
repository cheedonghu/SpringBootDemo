package com.east.demo.other.algorithm.backtrace.list;


import com.east.demo.other.algorithm.tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一颗二叉树，搜索值为7的目标节点，保存根节点到目标节点的路径，且排除值为3的元素
 * <p>
 * 关键点：回溯，剪枝
 *
 * @author: east
 * @date: 2023/12/25
 */
public class TreeTrace {
    /**
     * 使用前序遍历寻找树中为7的节点。
     *
     * @param root    root
     * @param path    当前路径
     * @param pathRes 路径结果
     */
    public void findTrace(TreeNode root, List<TreeNode> path, List<List<TreeNode>> pathRes) {
        // null：回溯； 9：剪枝
        if (root == null || root.value == 9) {
            return;
        }

        path.add(root);
        if (root.value == 7) {
            ArrayList<TreeNode> treeNodes = new ArrayList<>(path);
            pathRes.add(treeNodes);
        }

        findTrace(root.left, path, pathRes);
        findTrace(root.right, path, pathRes);

        // 回退
        // 去掉当前路径
        path.remove(path.size() - 1);
    }

    /**
     * 寻找树路径的回溯公式写法
     *
     * @param state   路径
     * @param choices 全部选择
     * @param res     结果
     */
    public void backtrace(List<TreeNode> state, List<TreeNode> choices, List<List<TreeNode>> res) {
        if (isSolution(state)) {
            recordSolution(state, res);
            return;
        }

        for (TreeNode choice : choices) {
            // 剪枝，判断是否合法
            if (isValid(state, choice)) {
                makeChoice(state, choice);
                backtrace(state, Arrays.asList(choice.left, choice.right), res);
                undoChoice(state, choice);
            }
        }
    }

    /**
     * 回退状态
     *
     * @param state  状态
     * @param choice 选择
     */
    private void undoChoice(List<TreeNode> state, TreeNode choice) {
        if (!state.isEmpty()) {
            state.remove(state.size() - 1);
        }
    }

    /**
     * 更新状态
     *
     * @param state  状态
     * @param choice 选择
     */
    private void makeChoice(List<TreeNode> state, TreeNode choice) {
        state.add(choice);
    }

    /**
     * 剪枝判断在该情况下选择是否合法
     *
     * @param state  路径
     * @param choice 当前情况
     * @return res
     */
    private boolean isValid(List<TreeNode> state, TreeNode choice) {
        return choice != null && choice.value != 9;
    }

    private void recordSolution(List<TreeNode> state, List<List<TreeNode>> res) {
        // 新建一个数组，如果直接用原引用结果会随着路径被修改
        ArrayList<TreeNode> treeNodes = new ArrayList<>(state);
        res.add(treeNodes);
    }

    /**
     * 判断是否是为解
     *
     * @param state 当前路径
     * @return res
     */
    private boolean isSolution(List<TreeNode> state) {
        return !state.isEmpty() && 7 == state.get(state.size() - 1).value;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.deserializeTree();
        TreeTrace treeTrace = new TreeTrace();
        List<TreeNode> path = new ArrayList<>();
        ArrayList<List<TreeNode>> pathRes = new ArrayList<>();
        // 传统解法
        System.out.println("start1");
        long start1 = System.currentTimeMillis();
        treeTrace.findTrace(root, path, pathRes);
        long end1 = System.currentTimeMillis();

        // 公式解法
        ArrayList<TreeNode> state = new ArrayList<>();
        ArrayList<List<TreeNode>> res = new ArrayList<>();
        long start2 = System.currentTimeMillis();
        treeTrace.backtrace(state, List.of(root), res);
        long end2 = System.currentTimeMillis();

        System.out.println((end1 - start1) + "ms" + "\t" + (end2 - start2) + "ms");
    }
}
