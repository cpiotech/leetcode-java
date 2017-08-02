package com.cp.interview.linkedlist;

/**
 * Created by curry on 7/14/17.
 */
public class RemoveNthNodeFromEndList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        //if remove the first node
        if (fast == null) {
            head = head.next;
            return head;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);

        a.next = b;
        b.next = c;
        c.next = d;

        ListNode result = removeNthFromEnd(a, 2);
        System.out.println(result.val);
    }
}
