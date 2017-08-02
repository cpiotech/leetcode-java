package com.cp.interview.linkedlist;

/**
 * Created by curry on 8/2/17.
 */
public class InsertionSortList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static ListNode insertionSortList(ListNode head) {

    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(insertionSortList(a));
    }
}
