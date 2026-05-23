package com.east.demo.other.algorithm.doublepoint;

import com.east.demo.other.algorithm.ListNode;

public class EntryNodeOfLoop {


    /**
     * 判断是否有环
     *
     * 快慢指针
     * 快->每次两个节点
     * 慢->每次1个节点
     * 若快慢指针相遇了，则说明有环（有环时，快慢指针会在环内跑圈）. 循环结束条件呢？ 快指针遇到null（有环的话，快指针不可能会遇到null）
     * 1, 2, 3, 4, 5
     * ij
     *    i  j
     *       i     j
     *    j     i
     *          j  i
     * ij
     *
     */
    public boolean hasCycle(ListNode pHead) {
        if(pHead==null){
            return false;
        }
        ListNode quick=pHead;
        ListNode slow=pHead;

        // quick指针先跑，若它为null则说明无环
        while(quick!=null){
            if(quick.next==null){
                return false;
            }else if(quick.next.next==null){
                return false;
            }
            quick=quick.next.next;

            slow=slow.next;

            // 若两者相遇，说明有环
            if(quick.val==slow.val){
                return true;
            }
        }

        return false;
    }


    /**
     * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
     *
     * 环->快慢指针
     *
     * 快指针：每次走两步
     * 慢指针：每次走一步
     *
     * 快指针到尾后，再次回到开头，直到慢指针到底结束？ 若有环，则快慢指针会相遇
     */
    public ListNode entryNodeOfLoop(ListNode pHead) {
        if(pHead.next==null||pHead.next.next==null){
            return null;
        }
        ListNode quick=pHead.next.next;
        ListNode slow=pHead.next;

        while(slow!=null&&quick.val!=slow.val){
            if(quick.next==null){
                quick=pHead.next;
            }else if(quick.next.next==null){
                quick=pHead;
            }else{
                quick=pHead.next.next;
            }

            // 慢指针遇到尾了，说明没有环
            if(slow.next==null){
                return null;
            }else {
                slow=slow.next;
            }
        }
        return slow;

    }

    public static void main(String[] args) {
        EntryNodeOfLoop entryNodeOfLoop = new EntryNodeOfLoop();

//        ListNode listNode = entryNodeOfLoop.entryNodeOfLoop(ListNode.cycle());
//        System.out.println(listNode.val);

        System.out.println(entryNodeOfLoop.hasCycle(ListNode.cycle()));

    }
}
