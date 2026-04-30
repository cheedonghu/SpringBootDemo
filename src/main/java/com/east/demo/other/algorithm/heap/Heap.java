package com.east.demo.other.algorithm.heap;

import java.util.ArrayList;

/**
 * 小顶堆
 * 基本属性：
 * 1.对于任意节点，堆顶元素小于任意子树
 * 2.对于任意节点下标i，其父节点为(i-1)/2下取整。左子树为2*i+1，右子树为2*i+2
 *
 * @author: east
 * @date: 2026/4/21 11:20
 */
public class Heap {


    /**
     * 建堆: 将元素添加到数组末尾，再自底向上调整
     */
    public static void heapPush(ArrayList<Integer> heap, int num) {
        if (heap.isEmpty()) {
            heap.add(num);
            return;
        }

        heap.add(num);
        int i = heap.size() - 1;
        // 开始自底向上堆化
        int parentIndex = (i - 1) / 2;
        while (true) {
            int minIndex = parentIndex;
            int leftIndex = parentIndex * 2 + 1;
            int rightIndex = parentIndex * 2 + 2;

            if (leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex = leftIndex;
            }
            if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
                minIndex = rightIndex;
            }
            if (minIndex == parentIndex) {
                // 已满足堆
                break;
            }
            // 交换根节点和最小值
            int min = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, min);
            parentIndex = (parentIndex - 1) / 2;
        }
    }

    /**
     * 出堆：将首位元素交换后，移除最后元素，再自顶向下堆化
     */
    public static int heapPop(ArrayList<Integer> heap) {
        if (heap.isEmpty()) {
            throw new RuntimeException();
        }
        int lastIndex = heap.size() - 1;
        int min = heap.get(0);
        heap.set(0, heap.get(lastIndex));
        heap.remove(lastIndex);

        // 交换完毕，开始堆化
        int parentIndex = 0;
        while (true) {
            int leftIndex = parentIndex * 2 + 1;
            int rightIndex = parentIndex * 2 + 2;
            int minIndex = parentIndex;
            if (leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex = leftIndex;
            }
            if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
                minIndex = rightIndex;
            }
            if (minIndex == parentIndex) {
                // 根节点最小时，堆化完成
                break;
            }
            int tempMin = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, tempMin);
            parentIndex = minIndex;
        }
        return min;

    }
}
