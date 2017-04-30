package com.cp.interview;

import java.util.Stack;

/**
 * Created by curry on 4/9/17.
 */
/*
https://leetcode.com/problems/implement-queue-using-stacks/#/description
 */
public class QueueByTwoStack1 {
    private Stack<Integer> inbox = new Stack<>();
    private Stack<Integer> outbox = new Stack<>();

    /** Push element x to the back of queue. */
    public void push(int x) {
        inbox.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }

        return outbox.pop();
    }

    /** Get the front element. */
    public int peek() {
        return outbox.isEmpty()? inbox.get(0) : outbox.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return outbox.isEmpty() && inbox.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
