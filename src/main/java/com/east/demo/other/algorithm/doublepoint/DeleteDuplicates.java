package com.east.demo.other.algorithm.doublepoint;

import com.east.demo.other.algorithm.ListNode;

/**
 *
 * @author: east
 * @date: 2026/5/3 23:05
 */
public class DeleteDuplicates {

    /**
     * 删除给出链表中的重复元素（链表中元素从小到大有序），使链表中的所有元素都只出现一次例如：
     * 给出的链表为1→1→21→1→2,返回1→21→2.
     * 给出的链表为1→1→2→3→31→1→2→3→3,返回1→2→31→2→3.
     * 数据范围：链表长度满足0≤n≤1000，链表中任意节点的值满足∣val∣≤100
     * <p>
     * 链表->双指针->三指针->头插法
     *
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) {
            return head;
        }

        ListNode pre = new ListNode(1001);
        pre.next = head;
        ListNode result = pre;
        ListNode cur = head;
        ListNode next = cur.next;

        while (next != null) {
            if (cur.val == next.val) {
                // 重复，删除当前元素
                pre.next = next;
                cur = next;
                next = next.next;
            } else {
                pre = cur;
                cur = next;
                next = next.next;
            }
        }

        return result.next;

    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(1, listNode4);
        ListNode listNode2 = new ListNode(1, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        // ListNode head = reverseBetween(listNode1, 4, 5);

        ListNode head = deleteDuplicates(listNode1);

        System.out.println(head.val);
    }
}
