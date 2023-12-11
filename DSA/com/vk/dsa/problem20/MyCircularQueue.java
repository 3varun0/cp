package com.vk.dsa.problem20;

import java.util.Arrays;

public class MyCircularQueue {

    int [] data;
    int maxSize;
    int curSize;
    int front;
    int rear;
    public MyCircularQueue(int sz) {
        this.maxSize = sz;
        data = new int[this.maxSize];
        curSize = 0;
        front = 0;
        rear = 0;
    }

    public boolean isFull () {
        return curSize == maxSize;
    }
    public boolean isEmpty() {
        return curSize == 0;
    }

    public void enqueue(int val) {
        if (isFull()) {
            System.out.println("CircularQueue is full, LRU data will be overriden!");
            data[rear] = val;
            rear = ((rear+1) % maxSize);
        } else {
            data[rear] = val;
            rear = (rear+1) % maxSize;
            curSize++;
        }
        Arrays.stream(data).forEach(i -> System.out.println(i));
    }
    public int dequeue () {
        int dequeue = 0;
        if (isEmpty()) {
            System.out.println("CircularQueue is empty. Element cannot be retrieved.");
        } else {
            dequeue = data[front];
            data[front] = -1;
            front = (front + 1) % maxSize;
            curSize--;
        }
        return dequeue;
    }
}
