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

    /**
     * 二叉搜索树与双向链表
     * 将树转为双向链表
     * <p>
     * 要求：空间复杂度
     * O(1)（即在原树上操作），时间复杂度
     * <p>
     * 注意:
     * 1.要求不能创建任何新的结点，只能调整树中结点指针的指向。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继
     * 2.返回链表中的第一个节点的指针
     * 3.函数返回的TreeNode，有左右指针，其实可以看成一个双向链表的数据结构
     * 4.你不用输出双向链表，程序会根据你的返回值自动打印输出
     * 输入描述：
     * 二叉树的根节点
     * 返回值描述：
     * 双向链表的其中一个头节点。
     * <p>
     * 分析：
     * 二叉搜索树->中序，有序i，递归(一次对次次对)
     * 链表->
     * O1->临时变量
     * 基本问题：中序遍历
     * 实现：在中序基础上，加两个变量pre和head，在原打印位置增加左右子树指向调整
     * 当是叶子时：左边pre为空，右边不管，pre成自己继续递归。（等下一个节点中处理：pre.right=node) 这样还特别巧妙，在下一个node中处理上个right不会造成节点丢失
     * pre代表前一个元素，前一个元素.right=当前节点，当前节点.left=前一个元素，pre更新为当前节点，继续递归
     *
     * @param pRootOfTree
     * @return
     */
    TreeNode head = null;
    TreeNode pre = null;

    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return pRootOfTree;
        convertDfs(pRootOfTree);

        return head;
    }

    private void convertDfs(TreeNode node) {
        if (node == null) return;

        convertDfs(node.left);
        if (head == null) {
            // 找到最小叶子，队列最左边，首元素
            head = node;
            pre = node;
            head.left = null;
        } else {
            // 非首元素
            // 开始调整指向
            pre.right = node;
            node.left = pre;
            pre = node;
        }

        convertDfs(node.right);
    }

    public static void main(String[] args) {

        TreeTraversal treeTraversal = new TreeTraversal();
        TreeNode root = TreeNode.searchTree();
        TreeNode head = treeTraversal.convert(root);
        while (head != null) {
            System.out.print(head.value + ", ");
            head = head.right;
        }

        System.out.println();

    }

}
