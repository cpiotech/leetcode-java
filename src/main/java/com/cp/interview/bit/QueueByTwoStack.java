package com.cp.interview.bit;

import java.util.Stack;

/**
 * Created by curry on 4/8/17.
 */

/*
Implement a MyQueue class which implements a queue using two stacks.
 */
public class QueueByTwoStack<T> {
    private Stack<T> inbox = new Stack<>();
    private Stack<T> outbox = new Stack<>();

    /*
     * Time complexity: O(1).
     * Space complexity: O(n).
     */
    public void queue(T item) {
        inbox.push(item);
    }

    /*
     * Time complexity: Worst-case O(n), but Amortized O(1).
     * Space complexity: O(n).
     */
    public T dequeue() {
        if (outbox.isEmpty()) {
            while (!inbox.isEmpty()) {
                outbox.push(inbox.pop());
            }
        }
        if (outbox.isEmpty()) {
            return null;
        }
        return outbox.pop();
    }

    public static void main(String[] args) {
        //demo
        QueueByTwoStack myQueue = new QueueByTwoStack<>();
        System.out.println(myQueue.dequeue());
        myQueue.queue(1);
        myQueue.queue(2);
        myQueue.queue(3);
        System.out.println(myQueue.dequeue());
        myQueue.queue(4);
        myQueue.queue(5);
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
        System.out.println(myQueue.dequeue());
    }
}
