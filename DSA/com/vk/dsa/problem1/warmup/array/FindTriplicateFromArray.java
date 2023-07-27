package com.vk.dsa.problem1.warmup.array;

/**
 * This program is to find a triplicate value from given array.
 *
 */
public class FindTriplicateFromArray {

    /**
     * TC : O(n)
     * @param args
     */
    public static void main(String[] args) {
        int arr[] = {1, 2,1,1,2};
        int triplicate = arr[0];
        for(int i = 1; i<arr.length; i++) {
            triplicate = triplicate ^ arr[i];
        }
        System.out.println(triplicate);
    }
}
