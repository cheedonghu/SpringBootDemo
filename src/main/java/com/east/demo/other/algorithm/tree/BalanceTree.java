package com.east.demo.other.algorithm.tree;

/**
 * 二叉平衡树
 *
 * @author: east
 * @date: 2026/4/12 15:28
 */
public class BalanceTree {

    /**
     * 平衡二叉树（Balanced Binary Tree），具有以下性质：
     * 它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
     * 高度差->基本模型做转化：二叉树高度->后序
     * 树->递归dfs
     * 操作的是节点还是节点子树？ 以每个节点为根进行操作->根左右
     *
     * @param pRoot
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode pRoot) {
        // write code here
        if (pRoot == null) {
            return true;
        }

        int height1 = height(pRoot.left);
        int height2 = height(pRoot.right);
        if (Math.abs(height1 - height2) > 1) {
            return false;
        }
        return IsBalanced_Solution(pRoot.left) && IsBalanced_Solution(pRoot.right);
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        // if(node.left==null && node.right==null) return 1;
        return Math.max(height(node.left), height(node.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode node = TreeNode.balanceTree();
        // TreeNode node = TreeNode.searchTree();

        BalanceTree balanceTree = new BalanceTree();
        System.out.println(balanceTree.IsBalanced_Solution(node));
    }
}
