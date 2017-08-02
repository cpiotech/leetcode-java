package com.cp.interview.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by curry on 7/15/17.
 */
public class RemoveDuplicatesfromSortedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = head;

        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);


        a.next = b;
        b.next = c;

        ListNode result = deleteDuplicates(a);
        System.out.println(result.val);
    }
}
