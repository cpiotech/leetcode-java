package com.cp.interview.linkedlist;

/**
 * Created by curry on 4/13/17.
 */
public class DeleteNode {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        if (nextNode != null) {
            node.val = nextNode.val;
            node.next = nextNode.next;
        } else {
            throw new IllegalArgumentException("Can't delete the last node with this method!");
        }
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;

        deleteNode(c);
        System.out.println(b.next.val);
    }
}
