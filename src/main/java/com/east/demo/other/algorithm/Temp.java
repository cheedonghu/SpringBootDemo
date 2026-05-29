package com.east.demo.other.algorithm;

import com.east.demo.other.algorithm.tree.TreeNode;

import java.util.LinkedList;

/**
 *
 * @author: east
 * @date: 2026/5/5 9:57
 */
public class Temp {


    public static boolean isCompleteTree(TreeNode root) {
        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean flag = false;
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node == null) flag = true;
            else {
                if (flag) {
                    return false;
                }
                deque.offer(node.left);
                deque.offer(node.right);
            }
        }
        return true;
    }


    public static void main(String[] args) {

        System.out.println(isCompleteTree(TreeNode.completeTree2()));
    }


}
