package com.vk.dsa.problem13;

import java.util.Stack;

/**
 * This problem is to solve the Histogram problem in TC : O(n)
 */
public class HistogramProblem {

    public static void main(String[] args) {
        int [] arr = {1,2,4,3,1};
        int maxArea = getMaxRectangleArea(arr);
        System.out.println(maxArea);

    }

    /**
     * This method calculates the area of maximum
     * rectangle from the given histogram.
     * @param arr
     * @return
     */
    private static int getMaxRectangleArea(int[] arr) {
        int maxArea = 0;
        int curArea = 0;
        int w = 0;
        int l = 0;
        int top = 0;
        int indexAsWidth = 0;
        int curH = 0;
        int prevH = 0;
        Stack<Integer> st = new Stack<>();

        while (indexAsWidth < arr.length) {
            curH = arr[indexAsWidth];
            prevH = st.isEmpty() ? -1 : arr[st.peek()];

            if (st.isEmpty() || curH >= prevH) {
                st.push(indexAsWidth++);
            } else {
                maxArea = findArea(arr, maxArea, curArea, w, l, top, indexAsWidth, st);
            }
        }
        while (!st.isEmpty()) {
            maxArea = findArea(arr, maxArea, curArea, w, l, top, indexAsWidth, st);
        }
        return maxArea;
    }

    private static int findArea(int[] arr, int maxArea, int curArea, int w, int l, int top, int indexAsWidth, Stack<Integer> st) {
        w = 0;
        l = 0;
        top = st.pop();
        if (st.isEmpty()) {
            w = indexAsWidth;
        } else {
            w = indexAsWidth - (st.peek() + 1);
        }
        l = arr[top];
        curArea = w * l;
        return curArea > maxArea ? curArea : maxArea;
    }
}
