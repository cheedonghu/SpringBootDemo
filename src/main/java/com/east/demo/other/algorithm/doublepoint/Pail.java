package com.east.demo.other.algorithm.doublepoint;

import com.east.demo.other.algorithm.ListNode;

import java.util.LinkedList;

/**
 * 是否是回文
 *
 * @author: east
 * @date: 2026/5/3 22:58
 */
public class Pail {

    /**
     * 给定一个链表，请判断该链表是否为回文结构。
     * 回文是指该字符串正序逆序完全一致。
     * <p>
     * 链表->双指针
     * 回文->正序逆序->栈
     * <p>
     * 先遍历一遍，将node入栈，然后再遍历一遍和出栈元素比较，要求一样
     *
     */
    public boolean isPail(ListNode head) {
        // write code here

        ListNode node = head;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (node != null) {
            stack.addLast(node);
            node = node.next;
        }

        node = head;
        while (!stack.isEmpty()) {
            ListNode tail = stack.pollLast();
            if (tail.val != node.val) {
                return false;
            }
            node = node.next;
        }

        return true;


    }
}
