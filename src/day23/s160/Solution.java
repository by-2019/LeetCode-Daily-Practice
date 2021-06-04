package day23.s160;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode sA = headA;
        ListNode sB = headB;
        while (sA != sB) {
            sA = sA == null ? headB : sA.next;
            sB = sB == null ? headA : sB.next;
        }
        return sA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode next = new ListNode(1);
        ListNode tmpA = headA;
        tmpA.next = next;
        tmpA = next;

        ListNode headB = new ListNode(5);
        next = new ListNode(0);
        ListNode tmpB = headB;
        tmpB.next = next;
        tmpB = next;
        next = new ListNode(1);
        tmpB.next = next;
        tmpB = next;

        next = new ListNode(8);
        tmpA.next = next;
        tmpB.next = next;
        tmpA = next;
        next = new ListNode(4);
        tmpA.next = next;
        tmpA = next;
        next = new ListNode(5);
        tmpA.next = next;

        Solution s = new Solution();
        System.out.println(s.getIntersectionNode(headA, headB).val);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}