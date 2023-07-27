package com.vk.dsa.problem2.stack;

/**
 * Own Stack data structure.
 */
public class Stack {
    int maxSz;
    int [] arr;
    int top;
    public Stack(int sz) {
        maxSz = sz;
        arr = new int[maxSz];
        top = -1;
    }

    /**
     * tells whether stack is full or not.
     * TC O(1)
     * @return
     */
    public boolean isFull() {
        return top == maxSz-1;
    }

    /**
     * tells whether stack is empty or not.
     * TC O(1)
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * pushes a new value into stack.
     * TC : O(1)
     * @param val
     */
    public void push(int val) {
        if (isFull()) {
            System.out.println("Stack is full, can't push new value");
        } else {
            arr[++top] = val;
        }
    }

    /**
     * removes last value from stack
     * TC : O(1)
     * @return
     */
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty, can't pop.");
            return top;
        } else {
            int val = arr[top];
            arr[top--] = 0;
            return val;
        }
    }

    /**
     * reads last value of stack
     * TC : O(1)
     * @return
     */
    public int peek () {
        if (isEmpty()) {
            System.out.println("Stack is empty, can't peek.");
            return top;
        } else {
            return arr[top];
        }
    }

    public static void main(String[] args) {
        Stack st = new Stack(5);
        st.push(10);
        st.push(11);
        st.push(12);
        st.push(13);
        st.push(14);

        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.peek());
    }
}
