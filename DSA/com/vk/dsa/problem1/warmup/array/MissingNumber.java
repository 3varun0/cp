package com.vk.dsa.problem1.warmup.array;

/**
 * this program is to find the missing number from a given array of n size
 * values can be orders or unordered.
 * Hint : use maths formula : n * ((n+1)/2)
 */
public class MissingNumber {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 0, 8, 9};
        int missing = 0;
        int sumOfArr = 0;
        int sumOfN = 0;
        int n = 9;
        sumOfN = n * ((n+1)/2);
        for (int i : arr) {
            sumOfArr += i;
        }
        missing = sumOfN - sumOfArr;
        System.out.println(missing);
    }
}
