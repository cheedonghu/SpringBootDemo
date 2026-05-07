package com.east.demo.other.algorithm.doublepoint.doublesplit;

/**
 *
 * @author: east
 * @date: 2026/5/4 10:17
 */
public class Search {

    /**
     * 请实现无重复数字的升序数组的二分查找 给定一个 元素升序的、无重复数字的整型数组 nums 和一个目标值 target ，
     * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标（下标从 0 开始），否则返回 -1
     * 数据范围： 0 ≤ l e n ( n u m s ) ≤ 2 × 1 0 5  ，
     * 数组中任意值满足 ∣val∣≤10 9
     * 进阶：时间复杂度 O ( log ⁡ n ) O(logn) ，空间复杂度 O ( 1 ) O(1)
     * <p>
     * 二分查找->base: 二分查找
     * <p>
     * i,j,index=(i+j)/2, 找到结果或当两次index一样时，跳出循环
     */
    public static int search(int[] nums, int target) {
        // write code here
        if (nums.length == 0) return -1;
        int i = 0;
        int j = nums.length;
        int index = (i + j) / 2;
        int before = -1;
        while (index != before) {
            if (nums[index] > target) {
                j = index;
                before = index;
                index = (i + j) / 2;
            } else if (nums[index] < target) {
                i = index;
                before = index;
                index = (i + j) / 2;
            } else {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println(search(nums, 3));
    }
}
