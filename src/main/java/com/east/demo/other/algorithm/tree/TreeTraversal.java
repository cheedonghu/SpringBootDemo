package com.east.demo.other.algorithm.tree;

import java.util.*;

/**
 * 树的遍历
 * <p>
 *
 * @author: east
 * <p>
 * @date: 2026/4/7 12:18
 */
public class TreeTraversal {

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root.value);
        preorder(root.left);
        preorder(root.right);
    }

    /**
     * 中序遍历递归实现
     * 只需关注一层递归正确性，后面自然会正确，这就是递归的特性。但这一层的处理也很抽象？
     *
     * @param root
     */
    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        preorder(root.left);
        System.out.println(root.value);
        preorder(root.right);
    }

    public void postorder(TreeNode root) {
        if (root == null) {
            return;
        }
        preorder(root.left);
        preorder(root.right);
        System.out.println(root.value);
    }

    /**
     * 后序遍历基于迭代实现
     * 引入两个栈，一个保存工作节点，一个保存结果
     * 工作栈先压入根节点
     * 迭代
     * 当工作栈有节点，则弹出该节点至结果栈（从而最后弹出），然后压入节点左右子树（因为后序是左右根，结果栈正好倒叙，弹出时会再倒一次）
     * 重复该操作直到工作栈结束，弹出结果栈
     *
     * @param root
     */
    public void postorder2(TreeNode root) {
        LinkedList<TreeNode> workStack = new LinkedList<>();
        LinkedList<TreeNode> resultStack = new LinkedList<>();

        workStack.addLast(root);

        while (!workStack.isEmpty()) {
            TreeNode treeNode = workStack.pollLast();
            resultStack.addLast(treeNode);
            if (treeNode.left != null) {
                workStack.addLast(treeNode.left);
            }
            if (treeNode.right != null) {
                workStack.addLast(treeNode.right);
            }
        }

        while (!resultStack.isEmpty()) {
            System.out.print(resultStack.pollLast().value + ", ");
        }

    }

    /**
     * 层序遍历
     * 属于广度优先。bfs一般需要借助队列实现
     * 工作队列加入root
     * 当工作队列不为空时，
     * 弹出队列首元素，加入该元素的左右子树到工作队列
     * 返回结束
     *
     * @param root
     */
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> deque = new LinkedList<>();

        deque.addLast(root);

        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.pollFirst();
            System.out.print(treeNode.value + ", ");
            if (treeNode.left != null) {
                deque.addLast(treeNode.left);
            }
            if (treeNode.right != null) {
                deque.addLast(treeNode.right);
            }
        }

    }

    /**
     * 按ArrayList<ArrayList<Integer>>格式返回层序，所以需要有两个工作队列，每个队列只存同一层节点
     *
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);

        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                ArrayList<Integer> tempResult = new ArrayList<>();

                while (!queue1.isEmpty()) {
                    TreeNode treeNode = queue1.poll();
                    tempResult.add(treeNode.value);
                    if (treeNode.left != null) {
                        queue2.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue2.add(treeNode.right);
                    }
                }
                result.add(tempResult);

            } else {
                ArrayList<Integer> tempResult = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    TreeNode treeNode = queue2.poll();
                    tempResult.add(treeNode.value);
                    if (treeNode.left != null) {
                        queue1.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue1.add(treeNode.right);
                    }
                }
                result.add(tempResult);
            }

        }
        Integer[] array = result.stream().flatMap(List::stream).toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));
        return result;
    }

    /**
     * 之字形打印，第一层从左到右，第二层从右到左->一个队列一个栈
     * 和层序类似，只需要将第二个工作队列换成栈,然后队列采用右左入栈，栈采用左右入队列
     *
     * @param root
     * @return
     */
    public ArrayList<ArrayList<Integer>> zigOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        // queue2的节点输出后需要倒序
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        queue1.addLast(root);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            if (!queue1.isEmpty()) {
                ArrayList<Integer> tempResult = new ArrayList<>();
                while (!queue1.isEmpty()) {
                    TreeNode treeNode = queue1.pollFirst();
                    tempResult.add(treeNode.value);
                    if (treeNode.left != null) {
                        queue2.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue2.addLast(treeNode.right);
                    }
                }
                result.add(tempResult);
            } else {
                ArrayList<Integer> tempResult = new ArrayList<>();
                while (!queue2.isEmpty()) {
                    TreeNode treeNode = queue2.pollFirst();
                    tempResult.add(treeNode.value);
                    if (treeNode.left != null) {
                        queue1.addLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue1.addLast(treeNode.right);
                    }
                }
                Collections.reverse(tempResult);
                result.add(tempResult);
            }
        }


        Integer[] array = result.stream().flatMap(List::stream).toArray(Integer[]::new);
        System.out.println(Arrays.toString(array));
        return result;
    }

    /**
     * 深度->dfs->递归
     * 最大深度->max(左子树，右子树)
     * 递归+max
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        int depth1 = maxDepth(root.left);
        int depth2 = maxDepth(root.right);
        return Math.max(depth1, depth2) + 1;
    }

    /**
     * 是否由目标路径->遍历
     * 在每个节点做操作->前序遍历
     * 逻辑：
     * 递归退出条件：root为null
     * 操作->判断临时总值是否满足，若满足直接返回true
     * 用与运算取左右子树递归结果
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        // write code here
        if (root == null) {
            return false;
        }
        return findPath(root, sum, 0);

    }

    private boolean findPath(TreeNode root, int sum, int temp) {
        if (root == null) return false;

        temp = temp + root.value;
        // 是叶子节点
        if (root.left == null && root.right == null) {
            return sum == temp;
        }

        return findPath(root.left, sum, temp) || findPath(root.right, sum, temp);


    }

    public static void main(String[] args) {

        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode root = TreeNode.simple3();

        System.out.println(treeTraversal.hasPathSum(root, 22));

    }

}
