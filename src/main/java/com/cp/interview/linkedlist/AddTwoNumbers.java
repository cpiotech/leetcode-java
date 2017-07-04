package com.cp.interview.linkedlist;

/**
 * Created by curry on 6/26/17.
 */
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3 = newHead;

        while (p1 != null || p2 != null) {
            if (p1 != null) {
                carry += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                carry += p2.val;
                p2 = p2.next;
            }

            p3.next = new ListNode(carry % 10);
            p3 = p3.next;
            carry /= 10;
        }

        if (carry == 1)
            p3.next = new ListNode(1);

        return newHead.next;
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

        ListNode result = addTwoNumbers(a, e);
        System.out.println(result.val);
    }
}
