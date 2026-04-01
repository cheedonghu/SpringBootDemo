package com.east.demo.other.algorithm.tree;

import com.east.demo.other.algorithm.util.Util;

/**
 * 重建树： 设置根节点，获取左子树的根位置然后设置左子树，获取右子树的根位置然后设置右子树；
 * 然后缩小下个子问题（根据lr缩小子树范围）进行递归(一次正确，次次正确！思维不用深入跟随递归！）；分治
 * https://www.hello-algo.com/chapter_divide_and_conquer/build_binary_tree_problem/#3
 * <p>
 * 关于重建：
 * 前序和后序（或层序）无法重建： 因为根据根和左子树无法确认右子树位置（因为左子树长度不确定），也就组合不了左右子树
 * 能否重建的关键就是能否确认：根与左右子树根 的位置，可以的化直接递归处理（树结构与递归基本绑定）
 * 根据中序的特性左根右因此知道了根节点即可确定左右子树的长度，从而以此分治，将问题分解为更小的树处理
 *
 * @author: east
 * @date: 2023/12/1
 */
public class RebuildTree {

    /**
     * 根据前序（根左右）和中序（左根右）遍历结果重建树（默认前提：节点值不同）。 分治
     * |根|左|右|
     * i i+1 i+1+m-l   单个树的下标关系
     * |左|根|右|
     * l  m  r
     *
     * @param preorder 前序
     * @param inorder  中序
     */
    public void buildTree(int[] preorder, int[] inorder) {
        // 根据前序和中序重建树；最初代码
//        TreeNode root = dfs(preorder, inorder, 0, Util.findIndex(inorder, preorder[0]), 0, inorder.length - 1);
        // 根据前序和中序重建树；优化后
        TreeNode root = dfs(preorder, inorder, 0, 0, inorder.length - 1);

        System.out.println("层序打印结果\n");
        root.printSimpleTree();
    }

    /**
     * @param preorder 前序遍历节点
     * @param inorder  中序遍历节点
     * @param i        根节点在前序遍历数组中下标
     * @param m        根节点在中序遍历数组中下标
     * @param l        根节点所表示的树的左范围（分治的子问题范围）
     * @param r        该树的右边界（分治的子问题范围）
     * @return 当前根节点
     */
    public TreeNode dfs(int[] preorder, int[] inorder, int i, int m, int l, int r) {
//        // r 和 l 重合时就可以直接返回了
//        if (r - l <= 1) {
//            return new TreeNode(m);
//        }
        // 子树区间为空时终止
        if (r - l < 0) {
            return null;
        }

        // 初始化根节点
        TreeNode root = new TreeNode(preorder[i]);
        // 左子树 note：这里传入m时用到了i+1下标的元素，会导致数组越界。需要改为逻辑内获取而不是通过参数传入，因为当越界时l和m会提前阻断
        root.left = dfs(preorder, inorder, i + 1, Util.findIndex(inorder, preorder[i + 1]), l, m - 1);
        // 右子树
        root.right = dfs(preorder, inorder, i + 1 + m - l, Util.findIndex(inorder, preorder[i + 1 + m - l]), m + 1, r);
        return root;
    }

    /**
     * 深度遍历优化版，去掉参数 m：根节点在中序遍历数组中下标参数改为逻辑中计算
     *
     * @param preorder 前序遍历节点
     * @param inorder  中序遍历节点
     * @param i        根节点在前序遍历数组中下标
     * @param l        根节点所表示的树的左范围，这里因为使用rl关系来判断节点是否有子树，所以传的参数以中序维度进行的（分治的子问题范围）
     * @param r        该树的右边界（分治的子问题范围）
     * @return 当前根节点
     */
    public TreeNode dfs(int[] preorder, int[] inorder, int i, int l, int r) {
        // 子树区间为空时终止
        if (r - l < 0) {
            return null;
        }

        // 初始化根节点
        TreeNode root = new TreeNode(preorder[i]);

        // 获取根节点在中序遍历数组中的下标从而确定左子树，右子树长度
        int m = Util.findIndex(inorder, preorder[i]);

        // 左子树. 只能用m与l的相对位置，不能直接使用
        root.left = dfs(preorder, inorder, i + 1, l, m - 1);
        // 右子树
        root.right = dfs(preorder, inorder, i + 1 + m - l, m + 1, r);
        return root;
    }

    public void buildTreeByInAndPost(int[] inorder, int[] postorder) {
        // 根据后序和中序重建树；
        TreeNode root = rebuildByInAndPost(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);

        System.out.println("层序打印结果\n");
        root.printSimpleTree();
    }

    /**
     * 根据中序和后序重建树
     * 中序： 根据中序获取左右子树长度，从而划分左右子树(分治）
     * 后序： 根据后序特性确定根节点在尾部，从而获取子树根节点 i-1与 i-(r-m)-1
     * 左        根        右
     * l         m        r
     * 左        右       根
     * i-(r-m)-1   i-1      i
     * <p>
     * note： l, r是中序中用来划分左右子树绝对位置下标的，lr和i相对独立。不能产生直接关系。i-(r-m)-1能使用是因为用的相对关系
     *
     * @param inorder   中序
     * @param postorder 后序
     * @param i         后序中根节点下标
     * @param l         中序左边界 （用来确定子树的左边界）
     * @param r         中序右边界（用来确定子树的右边界）
     * @return 重建树根节点
     */
    public TreeNode rebuildByInAndPost(int[] inorder, int[] postorder, int i, int l, int r) {
        if (l > r) {
            return null;
        }

        // 获取根节点在中序列表中的下标 note: 搭配中序lr边界用来确定左右子树长度和子树的根节点位置
        int m = Util.findIndex(inorder, postorder[i]);

        // 初始化根节点
        TreeNode node = new TreeNode(postorder[i]);

        node.left = rebuildByInAndPost(inorder, postorder, i - (r - m) - 1, l, m - 1);
        node.right = rebuildByInAndPost(inorder, postorder, i - 1, m + 1, r);
        return node;
    }


    public static void main(String[] args) {
        int[] preorder = {3, 9, 4, 5, 2, 1, 7};
        int[] inorder = {4, 9, 5, 3, 1, 2, 7};
        int[] postorder = {4, 5, 9, 1, 7, 2, 3};

        int inorder2[] = {15, 9, 10, 3, 20, 5, 7, 8, 4};
        int postorder2[] = {15, 10, 9, 5, 4, 8, 7, 20, 3};

        RebuildTree rebuildTree = new RebuildTree();
        // 前序和中序
//        rebuildTree.buildTree(preorder, inorder);

        // 中序后后序
        rebuildTree.buildTreeByInAndPost(inorder2, postorder2);
    }
}
