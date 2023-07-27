package com.vk.dsa.problem12;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This problem is to create a stack data structure using Queue DS.
 *
 * This has two approaches :
 * 1-> Using two Queues
 *    1.1 ->bu making write heavy (better)
 *    1.2 ->by making read heavy
 * 2-> Using one Queue (this is most optimal solution)
 */
public class CreateStackUsingQueue {

    public static void main(String[] args) {
        /* approach 1 */
        /*MyStack1 st1 = new MyStack1();
        st1.push(11);
        st1.push(12);
        st1.push(13);
        st1.push(14);
        st1.push(15);

        System.out.println("approach 1 Reading top value in LIFO fashion : "+st1.peek());
        System.out.println("Removing : "+st1.pop());
        System.out.println("Reading : "+st1.pop());
        System.out.println("Reading : "+st1.pop());
        System.out.println("Reading : "+st1.peek());*/

        /* approach 2 */
        /*MyStack2 st3 = new MyStack2();
        st3.push(11);
        st3.push(12);
        st3.push(13);
        st3.push(14);
        st3.push(15);

        System.out.println("approach 2 Reading top value in LIFO fashion : "+st3.peek());
        System.out.println("Removing : "+st3.pop());
        System.out.println("Reading : "+st3.pop());
        System.out.println("Reading : "+st3.pop());
        System.out.println("Reading : "+st3.peek());*/

        /* approach 3 */
        MyStack3 st3 = new MyStack3();
        st3.push(11);
        st3.push(12);
        st3.push(13);
        st3.push(14);
        st3.push(15);

        System.out.println("approach 3 Reading top value in LIFO fashion : "+st3.peek());
        System.out.println("Removing : "+st3.pop());
        System.out.println("Reading : "+st3.pop());
        System.out.println("Reading : "+st3.pop());
        System.out.println("Reading : "+st3.peek());

    }
}

/**
 * Approach 1 : Using two queues & enqueue heavy
 */
class MyStack1 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int val) {
        if (q1.isEmpty()) {
            q1.offer(val);
            return;
        }
        if (!q1.isEmpty()) {
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
            q1.offer(val);
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        }
    }

    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty, nothing to remove...");
            return -1;
        } else {
            return q1.poll();
        }
    }

    public int peek() {
        return q1.peek();
    }
}

/**
 * Approach 2 : Using two queues & dequeue heavy
 */
class MyStack2 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int val) {
        q1.offer(val);
    }

    public int pop() {
        int val = 0;
        while (!q1.isEmpty()) {
            val = q1.poll();
            if (!q1.isEmpty()) {
                q2.offer(val);
            }
        }
        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        return val;
    }

    public int peek() {
        int val = 0;
        while (!q1.isEmpty()) {
            val = q1.poll();
            q2.offer(val);
        }

        while (!q2.isEmpty()) {
            q1.offer(q2.poll());
        }
        return val;
    }
}

/**
 * Approach 3 : Using only one queue & enqueue heavy
 */
class MyStack3 {
    Queue<Integer> q1 = new LinkedList<>();

    public void push(int val) {
        int sz = q1.size();
        if (sz == 0) {
            q1.offer(val);
        }else {
            q1.offer(val);
            for (int i=1; i<=sz; i++) {
                q1.offer(q1.poll());
            }
        }
    }

    public int pop() {
        return q1.poll();

    }

    public int peek() {
        return q1.peek();

    }
}