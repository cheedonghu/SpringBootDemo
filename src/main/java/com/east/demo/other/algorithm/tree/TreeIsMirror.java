package com.east.demo.other.algorithm.tree;

import java.util.LinkedList;

/**
 * 镜像二叉树
 *
 * @author: east
 * @date: 2026/4/11 15:40
 */
public class TreeIsMirror {

    /**
     * 和对称一个思路
     * 镜像->对称->都是同一层处理->层序
     * O(n)：原层序基础上加一个队列，每次处理一层，遍历出来后按数组规则对调就行
     * 空节点用临时数字补齐1001
     * 镜像->左右根:后序，这个应该是O(1)解法
     * 弄清楚到底是操作节点值还是操作子树
     *
     * @param pRoot
     * @return
     */
    public TreeNode mirror(TreeNode pRoot) {
        // write code here
        if (pRoot == null) return pRoot;

        LinkedList<TreeNode> queue1 = new LinkedList<>();
        queue1.addLast(pRoot);
        while (!queue1.isEmpty()) {
            TreeNode node = queue1.pollFirst();
            TreeNode temp = new TreeNode();
            if (node.left == null && node.right == null) {
                continue;
            } else if (node.left != null && node.right != null) {
                temp = node.left;
                node.left = node.right;
                node.right = temp;
                queue1.addLast(node.left);
                queue1.addLast(node.right);
            } else if (node.left != null) {
                node.right = node.left;
                node.left = null;
                queue1.addLast(node.right);
            } else {
                node.left = node.right;
                node.right = null;
                queue1.addLast(node.left);
            }
        }
        return pRoot;
    }

    //

    /**
     * O(1)解法
     * 将自身左右节点镜像
     * 操作左右子树!
     * 前序
     *
     * @param pRoot
     * @return
     */
    public TreeNode mirror2(TreeNode pRoot) {
        // write code here
        if (pRoot == null) return pRoot;

        if (pRoot.left == null && pRoot.right == null) {
            return pRoot;
        }

        TreeNode node;
        node = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = node;

        mirror(pRoot.left);
        mirror(pRoot.right);

        return pRoot;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeNode.simple4();
        TreeIsMirror treeIsMirror = new TreeIsMirror();
        TreeNode treeNode = treeIsMirror.mirror(treeNode1);

        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.levelOrder(treeNode);
    }
}
