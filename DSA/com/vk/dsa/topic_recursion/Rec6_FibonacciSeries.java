package com.vk.dsa.topic_recursion;

/**
 * This program is to find the fiboncci series for the the given term via recursion.
 */
public class Rec6_FibonacciSeries {
    public static void main(String[] args) {
        int term = 5;
        System.out.println(fib(term));
    }

    private static int fib(int term) {
        if (term == 1) {
            return 0;
        }
        if (term == 2) {
            return 1;
        }
        return fib(term-1) + fib(term-2);
    }
}
