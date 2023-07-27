package com.vk.dsa.problem22;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * This problem is to implement a solution
 * for reversing K elements of given Queue in O(n).
 */
public class ReverseKElementsOfQueue {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        q.offer(40);
        q.offer(50);
        q.offer(60);

        System.out.println("======Queue before reversing.======");
        q.forEach(i -> System.out.println(i));

        Stack<Integer> st = new Stack<>();
        int k = 3;
        for (int i=1; i<=k; i++) {
            st.push(q.poll());
        }
        while (!st.isEmpty()) {
            q.offer(st.pop());
        }
        int count = q.size() - k;
        while (count-- > 0) {
            q.offer(q.poll());
        }
        System.out.println("======Queue after reversing.======");
        q.forEach(i -> System.out.println(i));

    }


}
