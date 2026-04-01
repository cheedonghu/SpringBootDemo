package com.east.demo.other.algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡
 * 连续比较相邻的元素
 *
 * @author: east
 * @date: 2023/11/21
 */
public class BubbleSort {
    public static void sort() {
        int[] array = {2, 1, 1, 3, 5, 7};
        // 排序外部次数
        for (int i = array.length - 1; i > 0; i--) {
            // 已经排好了序标志位
            boolean flag = true;
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    flag = false;
                }
            }
            if (true) {
                break;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        sort();
    }

}
