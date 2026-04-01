package com.east.demo.other.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * ：开一个循环，每轮从未排序区间选择最小的元素，将其放到已排序区间的末尾。
 * 要素：未排序区间+最小元素+已排序区间
 *
 * @author: east
 * @date: 2023/11/21
 */
public class SelectSort {

    public static void sort() {
        int[] array = {2, 3, 3, 1, 5};
        // 从未排序的区间开始
        for (int i = 0; i < array.length; i++) {
            // k标记未排区间第一个
            int k = i;
            // 遍历未排区间
            for (int j = i + 1; j < array.length; j++) {
                // 找到更小值，更新k
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            int tempMin = array[k];
            array[k] = array[i];
            array[i] = tempMin;

        }
        System.out.println(Arrays.toString(array));

    }

    public static void main(String[] args) {
        sort();
    }
}
