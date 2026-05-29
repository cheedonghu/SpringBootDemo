package com.east.demo.other.algorithm.tree;

import java.util.LinkedList;

/**
 * 是否是完全二叉树
 *
 * @author: east
 * @date: 2026/5/29 10:57
 */
public class IsCompleteTree {


    /**
     * 方案二：层序遍历，层序遍历根本是一个接一个，那么完全二叉树判断时 只要在打印时判断node是否为null，若为null那么后面必定都是null，搞个
     * flag记录一下即可，当flag为真，则说明后面不允许再有数字
     *
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
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
        return false;

    }


    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * 方案一：层序->BFS+DFS->用完整层序法全部打印，取倒数第二行，从左往右，若#号后面有数字，则说明不是完全二叉树
     * 方案二：还是层序，只不过不通过最后的结果数组判断，在单层遍历时（for deque.size)时，
     *
     * @param root
     * @return
     */
    public static boolean isCompleteTree1(TreeNode root) {
        // write code here
        int height = height(root);
        String last = "";

        LinkedList<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        for (int level = 0; level < height; level++) {
            int size = deque.size();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                if (node != null) {
                    sb.append(node.value);
                    deque.offer(node.left);
                    deque.offer(node.right);
                } else {
                    sb.append('#');
                    deque.offer(null);   // 空節點的孩子也佔位,保證形狀完整
                    deque.offer(null);
                }
                sb.append(' ');
            }
            last = sb.toString();
            System.out.println(last);
        }

        // 取最后一行
        boolean flag = false;
        for (char c : last.toCharArray()) {
            // 若出现了#后还有数字则说明不是完全二叉树
            if (c == '#') {
                flag = true;
            } else {
                if (flag) {
                    return false;
                }
            }
        }
        return true;
    }
}
