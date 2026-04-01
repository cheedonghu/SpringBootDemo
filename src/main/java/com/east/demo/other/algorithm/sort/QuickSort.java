package com.east.demo.other.algorithm.sort;

import com.east.demo.other.algorithm.util.Util;

import java.util.Arrays;

/**
 * 快速排序 ：找一个基准数(最左边）array[left]，从最右开始(right)找比其小的数，再从左(left)找比其大的数，找到后交换，ij相遇则将base和ij交换。之后再以base进行
 * 分割，将分割的额外数组做同样的事
 * <p>
 * 关键点：基准数，左右指针，数组分割(需要分割依据），分治
 *
 * @author: east
 * @date: 2023/11/22
 */
public class QuickSort {

    public void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int base = partQuickSortBaseImproved(array, left, right);

        sort(array, left, base - 1);
        sort(array, base + 1, right);
    }

    public int partQuickSort(int[] array, int left, int right) {
        int base = array[left];
        int i = left, j = right;
        while (i < j) {
            // 必须<=有=，否则出现相等元素时，会死循环
            while (i < j && base <= array[j]) {
                j--;
            }
            while (i < j && base >= array[i]) {
                i++;
            }
            // 找到目标（这里也可能代表i=j，不过无所谓，相等时交换也没事）
            Util.swap(array, i, j);
        }
        // 基数换位，分割数组，小任务完成
        Util.swap(array, left, i);
        return i;
    }

    /**
     * 快排, 优化基准数：从左 中 右里面找一个中间数作为基准数
     */
    public int partQuickSortBaseImproved(int[] array, int left, int right) {
        // 设置基准数
        int index = getBase(array, left, (left + right) / 2, right);
        // 将基准数放到最左边从而复用之前逻辑（转化：烧水例子：空杯子->接水得到有水的杯子->烧水 . 有水的杯子怎么办？先把水倒了，得到空杯子->复用烧水逻辑 ）
        Util.swap(array, index, left);

        int base = array[left];
        // ij指针开始扫描
        int i = left;
        int j = right;
        while (i < j) {
            // j先开始，j找不到说明没找到比base小的，i找不到说明找不到比base大的
            while (i < j && base <= array[j]) {
                j--;
            }
            while (i < j && array[i] <= base) {
                i++;
            }
            // 交换数据
            Util.swap(array, i, j);
        }
        // 交换基准数位置返回最新基准数
        Util.swap(array, left, i);
        return i;
    }

    /**
     * 异或操作；两个条件只能满足一个
     */
    private int getBase(int[] array, int left, int mid, int right) {
        // note ^：异或，既不能同时满足，也不能同时不满足，只能满足一个条件

        // left<mid<right || right<mid<left
        if ((array[mid] < array[left]) ^ (array[mid] < array[right])) {
            return mid;
        } else if ((array[left] < array[mid]) ^ (array[left] < array[right])) {
            // mid<left<right || right<left<mid
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array11 = {5, 4, 3, 2, 1};
        int[] array2 = {10, 10, 10, 10, 10};
        int[] array3 = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5};
        int[] array4 = {12, 24, 15, 26, 14, -10, 9, 16, -28, -16, 9, -6, 7, -29, 3, -6, 4, 0, 7, 0};
        int[] array5 = {2, 3, 3, 1, 5};

        int[] array = array4;
        QuickSort sort = new QuickSort();
        sort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
}
