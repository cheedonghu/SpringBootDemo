package com.east.demo.other.algorithm;

import com.east.demo.other.algorithm.tree.TreeNode;
import com.east.demo.other.algorithm.tree.TreeTraversal;

/**
 *
 * @author: east
 * @date: 2026/5/5 9:57
 */
public class Temp {


    public static TreeNode Mirror(TreeNode pRoot) {
        // write code here
        if (pRoot == null) return pRoot;
        Mirror(pRoot.left);
        Mirror(pRoot.right);
        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;
        return pRoot;
    }


    public static void main(String[] args) {
        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.levelOrder(Mirror(TreeNode.simple()));
    }


}
