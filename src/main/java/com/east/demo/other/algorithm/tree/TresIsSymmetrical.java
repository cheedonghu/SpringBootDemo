package com.east.demo.other.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 是否对称
 *
 * @author: east
 * @date: 2026/4/10 10:57
 */
public class TresIsSymmetrical {
    /**
     * 对称->层序判断更好
     * 基础问题：层序转化
     *
     * @param pRoot
     * @return
     */
    public boolean isSymmetrical(TreeNode pRoot) {
        // write code here
        if (pRoot == null) return false;
        ArrayList<ArrayList> result = new ArrayList<>();
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.addLast(pRoot);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {

            if (!queue1.isEmpty()) {
                ArrayList<Integer> tempResult = new ArrayList<>();
                while (!queue1.isEmpty()) {
                    TreeNode node = queue1.pollFirst();
                    tempResult.add(node.value);
                    if (node.left == null && node.right == null) {
                        // 只有当叶子节点才不补全占位符
                        continue;
                    }
                    // 非叶子节点的空节点用占位符替代：1001
                    if (node.left != null) {
                        queue2.addLast(node.left);
                    } else {
                        queue2.addLast(new TreeNode(1001));
                    }
                    if (node.right != null) {
                        queue2.addLast(node.right);
                    } else {
                        queue2.addLast(new TreeNode(1001));
                    }
                }
                result.add(tempResult);
            }
            if (!queue2.isEmpty()) {
                ArrayList<Integer> tempResult = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    TreeNode node = queue2.pollFirst();
                    tempResult.add(node.value);
                    if (node.left == null && node.right == null) {
                        // 只有当叶子节点才不补全占位符
                        continue;
                    }
                    // 非叶子节点的空节点用占位符替代：1001
                    if (node.left != null) {
                        queue1.addLast(node.left);
                    } else {
                        queue1.addLast(new TreeNode(1001));
                    }
                    if (node.right != null) {
                        queue1.addLast(node.right);
                    } else {
                        queue1.addLast(new TreeNode(1001));
                    }
                }
                result.add(tempResult);
            }
        }

        // 遍历判断是否对称，根节点那个不需要判断
        boolean result2 = true;
        for (int i = 1; i < result.size(); i++) {
            ArrayList<Integer> level = result.get(i);
            for (int j = 0; j < level.size(); j++) {
                Integer m = level.get(j);
                Integer n = level.get(level.size() - j - 1);
                result2 = result2 && (Objects.equals(m, n));
            }
            if (!result2) {
                return false;
            }
        }
        return result2;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.symmetricalTree();

        TresIsSymmetrical tresIsSymmetrical = new TresIsSymmetrical();
        System.out.println(tresIsSymmetrical.isSymmetrical(treeNode));
    }
}
