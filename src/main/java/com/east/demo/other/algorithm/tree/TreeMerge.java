package com.east.demo.other.algorithm.tree;

/**
 * 树的合并
 *
 * @author: east
 * @date: 2026/4/11 14:21
 */
public class TreeMerge {
    /**
     * 已知两颗二叉树，将它们合并成一颗二叉树。合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
     * 树->dfs->递归
     * O(1)空间复杂度->原节点操作-> node=dfs()返回
     * 不影响遍历->前序
     * 每次遍历时，根打印处改为：将t1的值加上t2，或将t2赋值给t1
     * <p>
     * t1.left=dfs(t1.left,t1.left)
     * t2.left=dfs(t1.right,t1.right)
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // write code here
        if (t1 == null && t2 == null) {
            return t1;
        }

        if (t1 != null && t2 != null) {
            t1.value += t2.value;
        } else if (t1 != null) {
            // 仅t1不为空
            return t1;
        } else {
            // 仅t2不为空
            // t1=new TreeNode(t2.value);
            return t2;
        }


        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeNode.mergeTree1();
        TreeNode treeNode2 = TreeNode.mergeTree2();
        TreeMerge treeMerge = new TreeMerge();
        TreeNode treeNode = treeMerge.mergeTrees(treeNode1, treeNode2);

        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.levelOrder(treeNode);

    }
}
