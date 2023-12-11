package com.vk.dsa.problem21;

import java.util.Stack;

/**
 * This is the problem to create a Queue using internally Stack.
 */
public class QueueUsingStack {

    Stack<Integer> st;
    Stack<Integer> temp;
    public QueueUsingStack() {
        st = new Stack<>();
        temp = new Stack<>();
    }

    public void enQueue(int value) {
        if (st.isEmpty()) {
            st.push(value);
        } else {
            while (!st.isEmpty()) {
                temp.push(st.pop());
            }
            st.push(value);
            while(!temp.isEmpty()) {
                st.push(temp.pop());
            }
        }
    }
    public int deQueue() {
        if (st.isEmpty()) return -1;

        return st.pop();
    }
    public int peek() {
        if (st.isEmpty()) return -1;

        return st.peek();
    }
    public static void main(String[] args) {
        QueueUsingStack q1 = new QueueUsingStack();
        q1.enQueue(10);
        q1.enQueue(20);
        q1.enQueue(30);
        q1.enQueue(40);
        q1.enQueue(50);
        q1.enQueue(60);

        System.out.println(q1.deQueue());
        System.out.println(q1.peek());
    }
}
