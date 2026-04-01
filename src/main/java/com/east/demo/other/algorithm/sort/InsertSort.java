package com.east.demo.other.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * 已排序区间；下一个值
 * 将下一个值插入到已排序区间；循环往复
 *
 * @author: east
 * @date: 2023/11/21
 */
public class InsertSort {
    public static void sort() {
        int[] array = {2, 3, 3, 1, 5};

        // 外部循环次数
        for (int i = 1; i < array.length; i++) {
            // j为已排区间
            int j = i - 1;
            // 需要有一个base，因为array[j+1]=array[j];语句第一次运行会覆盖array[i](已排序列表扩张）
            int base = array[i];
            // 内循环；和目标元素对比，如果大于它，则向右移动一位直到找到目标元素位置（从小到大排序）
            // j>=0要在前面防止array[-1]被执行
            while (j >= 0 && array[j] > base) {
                array[j + 1] = array[j];
                j--;
            }
            // 找到目标位置(为j+1，因为j--，停下来时已经到目标位置-1了）
            array[j + 1] = base;
        }

        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        sort();
    }
}
