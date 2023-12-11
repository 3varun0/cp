package com.vk.dsa.problem1.warmup.array;

import java.util.Arrays;

/**
 * This program is to move all the zeros at LHS
 * and all ones at RHS in the given array/list.
 */
public class MoveZerosAndOnes {

    public static void main(String[] args) {
        int [] arr = {0, 1, 1, 1, 0, 1, 0, 1, 0, 0};
        int count = 0;

        //counting total zeros
        for (int v : arr) {
            if (v == 0) {
                count++;
            }
        }

        //marking all first elements with zeros
        for (int i=0; i<count; i++) {
            arr[i] = 0;
        }

        //marking all later elements with ones
        for (int i=count; i<arr.length; i++) {
            arr[i] = 1;
        }

        Arrays.stream(arr).forEach(i -> System.out.print(i+", "));
    }
}
