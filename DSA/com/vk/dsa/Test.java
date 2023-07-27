package com.vk.dsa;

import java.util.*;

public class Test {
    public static void main(String[] args) {    

        //sort the array
        int [] nums = {1,3,2,4,56,67,7,7,78,8};

        //sort the array

        Arrays.sort(nums);
        Arrays.stream(nums).forEach(i -> System.out.println(i));
        System.exit(0);

        MyCircularQueue st = new MyCircularQueue(3);
        System.out.println(st.enQueue(1));
        System.out.println(st.enQueue(2));
        System.out.println(st.enQueue(3));
        System.out.println(st.enQueue(4));
        System.out.println(st.Rear());
        System.out.println(st.isFull());
        System.out.println(st.deQueue());
        System.out.println(st.enQueue(4));
        System.out.println(st.Rear());

    }
}

class MyCircularQueue {

    int [] data;
    int curSize;
    int maxSize;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        maxSize = k;
        data = new int[maxSize];
        curSize = 0;
        front = 0;
        rear = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            data[curSize] = value;
            rear = ((rear+1) % maxSize);
            curSize++;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            System.out.println("CircularQueue is empty, there is no element to remove.");
            return false;
        } else {
            front = ((front+1) % maxSize);
            curSize--;
            return true;
        }
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[front-1];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return data[curSize-1];
        }
    }

    public boolean isEmpty() {
        return curSize == 0;
    }

    public boolean isFull() {
        return curSize == maxSize;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */