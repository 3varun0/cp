package com.vk.dsa.problem19;

import java.util.Stack;

/**
 * Sort the given stack in TC O(n^2) or less.
 */
public class SortStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(4);
        st.push(8);
        st.push(9);
        st.push(2);
        st.push(1);
        st = sortStack(st);
        System.out.println(st.toString());
    }

    private static Stack<Integer> sortStack(Stack<Integer> st) {
        Stack<Integer> st2 = new Stack<>();
        int temp = 0;
        while (!st.isEmpty()) {
            temp = st.pop();

            if (st2.isEmpty()) {
                st2.push(temp);
            } else {
                if (temp >= st2.peek()) {
                    st2.push(temp);
                } else if (!(temp >= st2.peek())) {
                    while (!(temp >= st2.peek())) {
                        st.push(st2.pop());
                    }
                    st2.push(temp);
                }
            }

        }
        return st2;
    }
}
