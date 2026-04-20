package com.east.demo.other.algorithm.tree;

import java.util.ArrayList;

/**
 * 二叉搜索树最近公共祖先
 *
 * @author: east
 * @date: 2026/4/12 16:21
 */
public class LowestCommonAncestor {

    /**
     * 二叉搜索树的最近公共祖先
     * 二叉搜索树->中序，有序递增，无重复元素
     * 公共祖先->共同节点->路径上的共同节点->路径->路径问题路径基本模型
     * <p>
     * 获取从根到这两个节点的路径，然后从后往前遍历找到相同的那个元素
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public int lowestCommonAncestor(TreeNode root, int p, int q) {
        // write code here

        ArrayList<Integer> path1 = new ArrayList<Integer>();
        ArrayList<Integer> path2 = new ArrayList<Integer>();
        path(root, p, path1);
        path(root, q, path2);

        if (path1.size() == 1 && path2.size() == 1) {
            return root.value;
        }


        for (int i = path1.size() - 1; i >= 0; i--) {
            for (int j = path2.size() - 1; j >= 0; j--) {
                if (path1.get(i) == path2.get(j)) {
                    return path2.get(j);
                }
            }

        }

        return p;
    }

    private void path(TreeNode root, int p, ArrayList<Integer> path1) {
        if (root == null) return;
        if (path1.contains(p)) return;

        path1.add(root.value);
        if (p == root.value) return;
        path(root.left, p, path1);
        path(root.right, p, path1);
        if (path1.contains(p)) {
            return;
        } else {
            path1.remove(root.value);
        }
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.searchTree2();

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(node, 0, 3));
    }
}
