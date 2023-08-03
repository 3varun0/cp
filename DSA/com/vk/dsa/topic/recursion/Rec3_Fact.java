package com.vk.dsa.topic.recursion;

/**
 * This problem is to find the factorial via recursion.
 * What is factorial ?
 * product of n positive decending numbers.
 * denaoted as : n!
 */
public class Rec3_Fact {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact(n));
    }

    private static int fact(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fact(n-1);
    }
}
