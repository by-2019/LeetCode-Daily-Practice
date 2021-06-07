package day24.s203;

/**
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (null == head) {
            return head;
        }
        ListNode tmp = head;
        while (tmp.next != null) {
            if (tmp.next.val == val) {
                tmp.next = tmp.next.next;
                continue;
            }
            tmp = tmp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode head = new ListNode();
        System.out.println(s.removeElements(head, 1));
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}