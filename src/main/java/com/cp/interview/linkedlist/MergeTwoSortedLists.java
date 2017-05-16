package com.cp.interview.linkedlist;

/**
 * Created by curry on 4/18/17.
 */
public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode p = head;

        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    p.next = l1;
                    l1=l1.next;
                } else {
                    p.next=l2;
                    l2=l2.next;
                }
                p = p.next;
            } else if (l1 != null) {
                p.next = l1;
                break;
            } else {
                p.next = l2;
                break;
            }
        }

        return head.next;
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(7);

        a.next = b;
        b.next = c;
        c.next = d;

        ListNode e = new ListNode(2);
        ListNode f = new ListNode(4);
        //ListNode g = new ListNode(6);
        //ListNode h = new ListNode(8);

        e.next = f;
        //f.next = g;
        //g.next = h;

        ListNode result = mergeTwoLists(a, e);
        System.out.println(result.val);
    }
}
