package com.east.demo.other.algorithm.sort;

import com.east.demo.other.algorithm.util.Util;

import java.util.Arrays;

/**
 * 堆排序: 输入数组并建立小顶堆，此时最小元素位于堆顶。不断执行出堆操作，依次记录出堆元素，即可得到从小到大排序的序列
 * 关键点：建立堆（小顶堆），堆会缩小仅处理有效堆
 *
 * @author: east
 * @date: 2023/11/29
 */
public class HeapSort {


    public void heapSort(int[] array) {
        if (array.length < 1) {
            return;
        }
        // 从最下面节点开始建堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            buildHeap(array, array.length - 1, i);
        }

        // 交换堆顶和堆有效数组尾部元素
        int size = array.length - 1;
        while (size > 0) {
            Util.swap(array, 0, size);
            size--;
            for (int i = array.length / 2 - 1; i >= 0; i--) {
                buildHeap(array, size, i);
            }
        }
    }

    /**
     * 建小顶堆操作（大顶堆只需判断条件取反即可）
     *
     * @param array     堆物理存储数组
     * @param size      堆边界下标
     * @param rootIndex 根节点下标
     */
    public void buildHeap(int[] array, int size, int rootIndex) {
        while (true) {
            // 左子树下标
            int left = rootIndex * 2 + 1;
            // 右子树下标
            int right = rootIndex * 2 + 2;
            int min = rootIndex;
            if (left <= size && array[left] < array[min]) {
                min = left;
            }
            if (right <= size && array[right] < array[min]) {
                min = right;
            }
            if (min == rootIndex) {
                break;
            }
            Util.swap(array, min, rootIndex);
            rootIndex = min;
        }

    }

    public static void main(String[] args) {
        int[] array0 = {};
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array11 = {5, 4, 3, 2, 1};
        int[] array2 = {10, 10, 10, 10, 10};
        int[] array3 = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5};
        int[] array4 = {12, 24, 15, 26, 14, -10, 9, 16, -28, -16, 9, -6, 7, -29, 3, -6, 4, 0, 7, 0};
        int[] array5 = {2, 3, 3, 1, 5};

        int[] array = array4;
        HeapSort sort = new HeapSort();
        sort.heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
