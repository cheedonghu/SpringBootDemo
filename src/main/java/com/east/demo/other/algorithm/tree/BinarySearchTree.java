package com.east.demo.other.algorithm.tree;

import java.util.ArrayList;

/**
 * 二叉搜索树
 *
 * @author: east
 * @date: 2026/4/11 22:07
 */
public class BinarySearchTree {

    /**
     * 判断是否是二叉搜索树：
     * 二叉搜索树->中序遍历递增数组
     * 有空间要求，递归
     * 操作的根节点，用了根的左右子树->根左右前序
     * 需要用到核心结果-> 需要return
     *
     * @param root
     * @return
     */
    // 不行，左左右子树还要和左根，根判断大小
    public boolean isValidBST_HAS_PROBLEM(TreeNode root) {
        // write code here
        // 这里代码不对！前序不行的，前序只能满足当前node的左右子树，后序结合最大值可以满足所有
        if (root == null) return true;
        if (root.left == null && root.right == null) return true; // 判断一个就行以二叉搜索树的定义

        if (root.left.value < root.value && root.value < root.right.value) {

        } else {
            return false;
        }

        return isValidBST_HAS_PROBLEM(root.left) && isValidBST_HAS_PROBLEM(root.right);
    }

    // 不行，还是失败，理解不了递归判断方法，32514案例过不了 [10,5,15,3,7,1,6]案例也过不了，但应该就是用个临时变量记录中序遍历时头上节点值，保证自己右子树要小于它? 草，真恶心
    private int leftMax = Integer.MAX_VALUE;

    /**
     * BST。二叉搜索树->中序
     * 搞一个pre节点，中序遍历一遍，每次和pre节点判断要求cur>pre，每个都满足即可
     *
     * @param root
     * @return
     */
    public static TreeNode pre;
    public static boolean result = true;
    public boolean isValidBST3(TreeNode root) {
        // write code here
        dfs3(root);

        return result;
    }

    private void dfs3(TreeNode node) {
        if (node == null) return;
        dfs3(node.left);

        if (pre == null) {
            // 最左下角
            pre = node;
        } else {
            // 非中序第一个元素，则开始判断大小是否满足搜索树递增要求
            if (node.value <= pre.value) result = false;
            pre = node;
        }

        dfs3(node.right);
    }

    /**
     * 判断是否是二叉搜索树：
     * 二叉搜索树->中序遍历递增数组
     * 没有空间要求，直接遍历完判断数组就好
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        // write code here
        if (root == null) return true;
        ArrayList<TreeNode> nodeArray = new ArrayList<>();
        dfs(root, nodeArray);

        boolean res = true;
        for (int i = 0; i < nodeArray.size() - 1; i++) {
            res = res && (nodeArray.get(i).value < nodeArray.get(i + 1).value);
        }
        return res;
    }

    private void dfs(TreeNode root, ArrayList<TreeNode> nodeArray) {
        if (root == null) return;

        dfs(root.left, nodeArray);
        nodeArray.add(root);
        dfs(root.right, nodeArray);
    }

    public static void main(String[] args) {
        // TreeNode node = TreeNode.searchTree();
        TreeNode node = TreeNode.simple();

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        System.out.println(binarySearchTree.isValidBST3(node));
    }
}
