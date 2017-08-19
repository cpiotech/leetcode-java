package com.cp.interview.linkedlist;

/**
 * Created by curry on 8/2/17.
 */
/*
http://courses.cs.washington.edu/courses/cse373/01wi/slides/Measurement/sld010.htm
https://leetcode.com/problems/insertion-sort-list/description/
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
        ListNode dummy = new ListNode(0);
        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
        // 所以这里不需要dummy.next = head;

        while (head != null) {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val) {
                node = node.next;//移動node至插入點前一值
            }
            ListNode temp = head.next; //準備下一個待插入值
            head.next = node.next; //將待插入值指向下一個
            node.next = head; //將前一值指向待插入值
            head = temp; //head變成下一個待插入值
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        System.out.println(insertionSortList(a));
    }
}
