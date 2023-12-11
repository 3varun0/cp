package com.vk.dsa.problem3.queue;

/**
 * This progarm is to create a basic queue data structure, i.e. MyQueue
 *
 */
public class MyQueue {
    int size;
    int []arr;
    int front;
    int rear;
    public MyQueue(int sz) {
        size = sz;
        arr = new int[size];
        front = 0;
        rear = -1;
    }
    public boolean isFull () {
        return rear == size-1;
    }
    public boolean isEmpty() {
        return rear == -1 || rear == front || front > rear;
    }

    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("Can't enqueue as queue is full.");
        } else {
            arr[++rear] = val;
        }
    }
    public int dequeue () {
        if (isEmpty()) {
            System.out.println("Can't dequeue as queue is empty.");
            return -1;
        } else {
            int val = arr[front];
            arr[front++] = 0;
            return val;
        }
    }

    public static void main(String[] args) {
        MyQueue q1 = new MyQueue(5);
        q1.enqueue(11);
        q1.enqueue(22);
        q1.enqueue(33);
        q1.enqueue(44);
        q1.enqueue(55);

        System.out.println(q1.dequeue());
    }
}