package com.east.demo.other.algorithm.sort;

import com.east.demo.other.algorithm.heap.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 堆排序: 输入数组并建立小顶堆，此时最小元素位于堆顶。不断执行出堆操作，依次记录出堆元素，即可得到从小到大排序的序列
 * 关键点：建立堆（小顶堆），堆会缩小仅处理有效堆
 *
 * 堆和树对应关系：对于任意下标为i的节点，有
 * parent=floor((i-1)/2)
 * left=2i+1
 * right=2i+2
 *
 *
 * @author: east
 * @date: 2023/11/29
 */
public class HeapSort {

    public void heapSort2(int[] array) {
        // 先建堆
        ArrayList<Integer> heap = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            Heap.heapPush(heap, array[i]);
        }

        // 从小到大返回
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            result.add(Heap.heapPop(heap));
        }

        // 返回排好序数组
        System.out.println(Arrays.toString(result.toArray()));
    }

    /**
     * 先将数组组成堆，然后自顶而下不断出堆即可
     *
     * @param array
     */
    public void heapSort(int[] array) {
        // 先建堆
        buildHeap(array);

        List<Integer> heap = Arrays.stream(array).boxed().collect(Collectors.toList());
        // 获取出堆元素
        ArrayList<Integer> result = new ArrayList<>();

        int size = heap.size();
        for (int i = 0; i < size; i++) {
            result.add(heapPop(heap));
        }

        // 返回排好序数组
        System.out.println(Arrays.toString(result.toArray()));
    }

    /**
     * 出堆：将堆顶元素和堆尾交换，堆尾元素移除，再自顶至低完成堆化
     *
     * @param heap
     */
    private int heapPop(List<Integer> heap) {
        if (heap.size() == 1) {
            return heap.get(0);
        }

        int parentIndex = 0;
        int lastIndex = heap.size() - 1;
        int min = heap.get(parentIndex);
        int last = heap.get(lastIndex);
        // 交换
        heap.set(0, last);
        // 移除
        heap.remove(lastIndex);

        // 自顶向下堆化
        while (true) {
            int leftIndex = parentIndex * 2 + 1;
            int rightIndex = parentIndex * 2 + 2;
            // int parent=heap.get(parentIndex);
            // int left=leftIndex>=heap.size()?10000:;
            // int right=rightIndex>=heap.size()?10000:heap.get(rightIndex);

            // 左子树最小，交换
            int minIndex = parentIndex;
            if (leftIndex < heap.size() && heap.get(leftIndex) < heap.get(minIndex)) {
                minIndex=leftIndex;

            }
            if (rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)) {
                minIndex = rightIndex;
            }
            if (minIndex == parentIndex) {
                break;
            }
            int tempMin = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, tempMin);
            parentIndex = minIndex;
        }

        return min;
    }

    /**
     * 建堆: 添加元素到队尾，自底向上堆化
     * @param array
     */
    private void buildHeap(int[] array) {
        // int[] heap = new int[array.length];
        // ArrayList<Integer> heap = new ArrayList<>();
        for (int i = array.length - 1; i > 0; i--) {

            int parentIndex = (i - 1) / 2;
            while (true) {
                int leftIndex = parentIndex * 2 + 1;
                int rightIndex = parentIndex * 2 + 2;
                // int parent=heap.get(parentIndex);
                // int left=leftIndex>=heap.size()?100000:heap.get(leftIndex); // 当子树下标越界则说明节点不存在，若为小顶堆则赋值最大值
                // int right=rightIndex>=heap.size()?100000:heap.get(rightIndex); // 当子树下标越界则说明节点不存在，若为小顶堆则赋值最大值

                // 左子树最小，交换
                int minIndex = parentIndex;
                if (leftIndex < array.length && array[leftIndex] < array[minIndex]) {
                    minIndex = leftIndex;
                }
                if (rightIndex < array.length && array[rightIndex] < array[minIndex]) {
                    minIndex = rightIndex;
                }
                if (minIndex == parentIndex) {
                    break;
                }
                int tempMin = array[minIndex];
                array[minIndex] = array[parentIndex];
                array[parentIndex] = tempMin;
                parentIndex = (parentIndex - 1) / 2;
            }
        }

        // return heap.stream()
        //         .mapToInt(i -> i)
        //         .toArray();

        // return heap;

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
        sort.heapSort2(array);
        // System.out.println(Arrays.toString(array));
    }
}
