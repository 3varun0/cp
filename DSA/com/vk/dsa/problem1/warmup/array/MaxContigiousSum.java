package com.vk.dsa.problem1.warmup.array;

/**
 * This program is to find the maximum contigious sum of given array in TC : O(n)
 */
public class MaxContigiousSum {

    public static void main(String[] args) {
        int [] arr = {-2, -1, 1, 4, 1, -7, -1, 1,2,-3};
        int targetMaxContSum = Integer.MIN_VALUE;
        int maxSum = 0;
        for (int v : arr) {
            maxSum = maxSum + v;

            if (maxSum > targetMaxContSum) {
                targetMaxContSum = maxSum;
            }
            if (maxSum < 0) {
                maxSum = 0;
            }
        }

        System.out.println("Maximum Contigious Sum : "+targetMaxContSum);
    }
}
