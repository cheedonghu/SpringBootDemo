package com.east.demo.other.algorithm.doublepoint;

import com.east.demo.other.algorithm.ListNode;

import java.util.LinkedList;

/**
 *
 * @author: east
 * @date: 2026/4/29 17:46
 */
public class ReverseBetween {


    /**
     * 一个节点数为 size 链表 m 位置到 n 位置之间的区间反转，要求时间复杂度 O(n)，空间复杂度 O(1)。
     * <p>
     * O(1),链表->双指针
     * <p>
     * 但是这个ListNode没有下标获取，只能next获取
     * <p>
     * 还是双指针思想，再观察到其实就是指针指向问题
     * <p>
     * 当到达m时，把m单独留下，~~cur指向当前，next指向后面，改next的next不行会断掉，不对，都一样，用三个pre,cur,next
     *
     *
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write code here
        if (m == n) {
            return head;
        }

        ListNode node = head;
        ListNode pre = null;
        ListNode cur = null;
        ListNode start = null;
        ListNode end = null;

        // 逐个遍历List
        int i = 1;
        // n作为终止标记
        // 终止条件：node为null或i>n
        while (!(node == null || i > n)) {
            // 当m个时，开始重新调整节点指向
            if (i == m) {
                // 初始化pre指针
                pre = node;
                node = node.next;
            } else if (i > m) {
                // 初始化cur指针
                cur = node;
                node = node.next;
                // 调整指向
                cur.next = pre;
                pre = cur;
            }
            // else if(i>=m){
            //     // 根据cur, next指针调整节点指向
            //     node=node.next;
            //     next=
            //
            // }
            else {
                start = node;
                node = node.next;
            }
            i++;
        }

        // 结束时，若node不为null，说明还没到头，则将start与node连，start.next与node.next连
        // 若start为null，则说明从首节点开始，则head是node，仅将
        if (node != null) {
            if (start == null) {
                head.next = node;
                return pre;
            } else {
                end = node;
                ListNode temp = start.next;
                start.next = pre;
                temp.next = end;
            }

        } else {
            // 当end为null时，说明已经到底
            // 当start也是null，清掉第一个的连接，直接返回最后一个
            if (start == null) {
                head.next = null;
                return pre;
            } else {
                start.next = pre;
            }

        }

        return head;

    }


    /**
     * 将给出的链表中的节点每 k 个一组翻转，返回翻转后的链表
     * 如果链表中的节点数不是 k 的倍数，将最后剩下的节点保持原样
     * 你不能更改节点中的值，只能更改节点本身。
     * <p>
     * 要求空间复杂度 O(1)，时间复杂度O(n)
     * 例如：
     * 给定的链表是
     * 1→2→3→4→5
     * k=2 , 你应该返回
     * 2→1→4→3→5
     * k=3 , 你应该返回
     * 3→2→1→4→5
     * <p>
     * <p>
     * 写个栈实现的吧
     * <p>
     * 翻转->栈
     *
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // write code here
        ListNode node = head;
        ListNode newNode = new ListNode(0); // 新链表
        ListNode retHead = newNode; // 新链表头
        ListNode cur = null;
        LinkedList<ListNode> stack = new LinkedList<>();
        while (node != null) {
            // 每k个元素
            int i = 1;
            while (node != null && i <= k) {
                stack.addLast(node);
                node = node.next;
                i++;
            }
            if (i == k + 1) {
                // 开始翻转
                while (!stack.isEmpty()) {
                    cur = stack.pollLast();
                    newNode.next = cur;
                    newNode = cur;
                }
                newNode.next = null;
            } else {
                // 到结尾，不用翻转了，正常连接上就行
                while (!stack.isEmpty()) {
                    cur = stack.pollFirst();
                    newNode.next = cur;
                    newNode = cur;
                }
            }

        }
        return retHead.next;
    }


    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5, null);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        // ListNode head = reverseBetween(listNode1, 4, 5);

        ListNode head = reverseKGroup(listNode1, 2);

        System.out.println(head.val);
    }
}
