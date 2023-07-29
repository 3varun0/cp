package com.vk.dsa.topic_recursion;

/**
 * This problem is to calculate sum of digits via recursion.
 */
public class Rec2_SumOfDigits{

    public static void main(String[] args) {
        System.out.println(sumOfDigits(123456));
    }

    private static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        int digit = n % 10;
        int remaining = n / 10;
        int lhs = sumOfDigits(remaining);
        return lhs + digit;
    }
}
