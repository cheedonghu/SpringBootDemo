package com.east.demo.other.algorithm;

/**
 * 一个简单的列表节点
 *
 * @author: east
 * @date: 2026/4/29 17:49
 */
public class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
