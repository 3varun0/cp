package com.vk.dsa.problem1.warmup.array;

/**
 * This program finds the duplicate from the given unordered array of consicutive integers.
 */
public class FindDuplicateFromArray {

    /**
     * TC : O(n)
     * @param args
     */
    public static void main(String[] args) {
        int [] arr = {1,2,5,6,3,4,3,7,8,9};
        int n = 9;
        int sumOfN = n * ((n+1)/2);
        int x = 10;
        int sumOfArr = 0;
        for (int i : arr) {
            sumOfArr += i;
        }
        int duplicate = sumOfArr - sumOfN;
        System.out.println(duplicate);
    }
}
