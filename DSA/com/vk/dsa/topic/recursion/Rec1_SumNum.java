package com.vk.dsa.topic.recursion;

/**
 * This recursion problem is to sum all numbers from 1 to n.
 */
public class Rec1_SumNum {

    public static void main(String[] args) {
        int n = 100;
        System.out.println(sumNumFromOneToN(n));
    }

    private static int sumNumFromOneToN(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int lhs = sumNumFromOneToN(n-1);
        int sum = lhs + n;
        //System.out.println(sum);
        return sum;
    }
}
