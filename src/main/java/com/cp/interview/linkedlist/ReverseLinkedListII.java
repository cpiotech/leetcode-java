package com.cp.interview.linkedlist;

/**
 * Created by curry on 7/28/17.
 */
/*
https://leetcode.com/problems/reverse-linked-list-ii/tabs/description/
 */
public class ReverseLinkedListII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        ListNode previous = head;
        ListNode current = head.next;
        ListNode nextNode = current;
        ListNode postnNode = current.next;
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nextNode;
            nextNode = postnNode;
            postnNode = temp;
        }
        current.next = postnNode;
        previous.next = nextNode;

        return dummy.next;

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

        ListNode result = reverseBetween(a, 2, 4);
        System.out.println(result.val);
    }
}
