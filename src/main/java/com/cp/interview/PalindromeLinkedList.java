package com.cp.interview;

/**
 * Created by curry on 4/15/17.
 */
public class PalindromeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode current = slow.next;
        ListNode previous = null;
        ListNode nextNode;
        while (current != null) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        ListNode firstHead = head;
        ListNode secondReverseHead = previous;
        while(secondReverseHead != null) {
            if (firstHead.val != secondReverseHead.val) {
                return false;
            }
            firstHead = firstHead.next;
            secondReverseHead = secondReverseHead.next;
        }

        current = previous;
        previous = null;
        while (current != null) {
            nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        return true;
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(isPalindrome(a));
    }
}
