package com.vk.dsa.problem11;

/**
 * Create a custom data structure using stack or queue
 * which has following operations with TC : O(n)
 * insert()
 * delete()
 * getMin()
 *
 *
 */
public class StackWithGetMin {
    MyStack st;
    MyStack minSt;

    public StackWithGetMin(int sz) {
        st = new MyStack(sz);
        minSt = new MyStack(sz);
    }

    public void insert(int val) {
        st.push(val);
        if (minSt.isEmpty()) {
            minSt.push(val);
        } else if (val < minSt.peek()) {
            minSt.push(val);
        }
    }

    public int delete () {
        int val = st.pop();
        if (val == minSt.peek()) {
            minSt.pop();
        }
        return val;
    }

    public int getMin() {
        return minSt.peek();
    }

    public static void main(String[] args) {
        StackWithGetMin ds = new StackWithGetMin(5);
        ds.insert(11);
        ds.insert(12);
        ds.insert(1222);
        ds.insert(18);
        ds.insert(2);
        ds.insert(22);
        System.out.println(ds.getMin());
        System.out.println(ds.delete());
        System.out.println(ds.getMin());
    }
}

class MyStack {

    int []arr;
    int top;
    int size;

    public MyStack(int sz) {
        size = sz;
        arr = new int [size];
        top = -1;
    }

    public boolean isFull() {
        return top == size-1;
    }
    public boolean isEmpty() {
        return top == -1;
    }
    public void push(int val) {
        if (isFull()) {
            System.out.println("Can't push "+val+", stack is full.");
        } else {
            arr[++top] = val;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Can't pop, stack is empty.");
            return -1;
        } else {
            int val = arr[top];
            arr[top--] = 0;
            return val;
        }
    }

    public int peek() {
        if(isEmpty()) {
            System.out.println("Nothing to read, stack is empty.");
            return -1;
        } else {
            return arr[top];
        }
    }
}
