package com.cp.interview;

/**
 * Created by curry on 4/13/17.
 */
public class RemoveLinkedListElements {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode helper = new ListNode(0);
        helper.next = head;
        ListNode p = helper;

        while (p.next != null){
            if (p.next.val == val) {
                ListNode next = p.next;
                p.next = next.next;
            } else{
                p = p.next;
            }
        }

        return helper.next;
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);

        a.next = b;
        b.next = c;
        c.next = d;

        ListNode result = removeElements(a, 2);
        System.out.println(result.val);
    }
}
