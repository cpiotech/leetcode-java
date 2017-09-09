package com.cp.interview.design;

import com.cp.interview.binarytree.MaximumDepthBinaryTree;
import com.cp.interview.linkedlist.LinkedListCycle;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by curry on 9/3/17.
 */
/*
https://leetcode.com/problems/lru-cache/description/
 */
public class LRUCacheDesign {
    static class Node {
        int value;
        int key;
        Node pre;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    public static class LRUCache {
        int capacity;
        HashMap<Integer, Node> map = new HashMap<>();
        Node head = null;
        Node end = null;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node n = map.get(key);
                remove(n);
                setHead(n);
                return n.value;
            }

            return -1;
        }

        public void remove(Node n) {
            if (n.pre != null) {
                n.pre.next = n.next;
            } else {
                head = n.next;
            }

            if (n.next != null) {
                n.next.pre = n.pre;
            } else {
                end = n.pre;
            }

        }

        public void setHead(Node n) {
            n.next = head;
            n.pre = null;

            if (head != null)
                head.pre = n;

            head = n;

            if (end == null)
                end = head;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                Node old = map.get(key);
                old.value = value;
                remove(old);
                setHead(old);
            } else {
                Node created = new Node(key, value);
                if (map.size() >= capacity) {
                    map.remove(end.key);
                    remove(end);
                    setHead(created);

                } else {
                    setHead(created);
                }

                map.put(key, created);
            }
        }


    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
