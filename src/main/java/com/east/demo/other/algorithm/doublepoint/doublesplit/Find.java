package com.east.demo.other.algorithm.doublepoint.doublesplit;

/**
 *
 * @author: east
 * @date: 2026/5/4 10:35
 */
public class Find {

    /**
     * 在一个二维数组array中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，
     * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * [
     * [1,2,8,9],
     * [2,4,9,12],
     * [4,7,10,13],
     * [6,8,11,15] ]
     * 给定 target = 7，返回 true。
     * 给定 target = 3，返回 false。
     * 数据范围：矩阵的长宽满足 0 ≤ n , m ≤ 500,
     * 矩阵中的值满足−10 9 ≤val≤10 9
     * 进阶：空间复杂度O(1) ，时间复杂度 O ( n + m ) O(n+m)
     * <p>
     * 数组，查找-> dfs
     * 升序查找->二分法
     * <p>
     * base选二分法，在原基础上，对每行进行二分找，时间复杂度O(m*logn)
     * <p>
     * 方法二：左下查找法，利用左下或右上开始的元素有大有小特性进行遍历
     * 左下开始->若大于target则往上，否则往右直到越界或找到
     * <p>
     * 方法三：base二分法：用递归把右边或下面都走一遍
     *
     * @param target
     * @param array
     * @return
     */
    public static boolean find(int target, int[][] array) {
        // write code here
        if (array == null || array.length == 0) return false;

        int x = array.length - 1;
        int y = 0;

        while (x > -1 && y <= array.length - 1) {
            if (array[x][y] == target) {
                return true;
            } else if (array[x][y] < target) {
                y = y + 1;
            } else {
                x = x - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] array = new int[4][4];
        array[0] = new int[]{1, 2, 8, 9};
        array[1] = new int[]{2, 4, 9, 12};
        array[2] = new int[]{4, 7, 10, 13};
        array[3] = new int[]{6, 8, 11, 15};

        System.out.println(find(16, new int[0][0]));
    }
}
