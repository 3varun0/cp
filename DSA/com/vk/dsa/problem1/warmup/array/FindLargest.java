package com.vk.dsa.problem1.warmup.array;

/**
 * This program is to find the largest three values from given array in O(n) TC.
 */
public class FindLargest {

    public static void main(String[] args) {
        int []arr = {1,3,5, 67,55,44,37,89, 990};
        int l1 = Integer.MIN_VALUE;
        int l2 = Integer.MIN_VALUE;
        int l3 = Integer.MIN_VALUE;

        for (int v : arr) {
            if (v > l1) {
                l3 = l2;
                l2 = l1;
                l1 = v;
            } else if (v > l2) {
                l3 = l2;
                l2 = v;
            } else if (v > l3) {
                l3 = v;
            }
        }
        System.out.println("Largest1 : "+l1);
        System.out.println("Largest2 : "+l2);
        System.out.println("Largest3 : "+l3);
    }
}
