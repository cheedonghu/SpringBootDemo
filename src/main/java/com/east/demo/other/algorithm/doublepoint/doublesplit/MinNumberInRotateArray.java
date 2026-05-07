package com.east.demo.other.algorithm.doublepoint.doublesplit;

/**
 *
 * @author: east
 * @date: 2026/5/4 16:16
 */
public class MinNumberInRotateArray {

    public static int minNumberInRotateArray(int[] nums) {
        // write code here
        if (nums.length == 1) return nums[0];
        int i = 0;
        int j = nums.length - 1;
        int lastBase = -1;
        int base = (i + j) / 2;

        while (i < j) {
            if (nums[base] > nums[j]) {
                i = base;
            } else if (nums[base] < nums[j]) {
                j = base;
            } else {
                j--;
            }
            base = (i + j) / 2;
        }

        return nums[i];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 2, 2, 2};
        System.out.println(minNumberInRotateArray(nums));
    }
}
