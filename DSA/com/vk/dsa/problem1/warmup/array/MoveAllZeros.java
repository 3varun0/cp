package com.vk.dsa.problem1.warmup.array;

import java.util.Arrays;

/**
 * This program is to move all the zeros from given array in the end.
 */
public class MoveAllZeros {

    public static void main(String[] args) {
        int []arr = {1, 0, 4, 0, 44, 0, 0, 56, 33};
        int count = 0;
        for (int v : arr) {
            if (v != 0) {
                arr[count++] = v;
            }
        }
        for (int i = count; i<arr.length; i++) {
            arr[i] = 0;
        }

        System.out.println("printing : ");
        Arrays.stream(arr).asLongStream().forEach(a -> System.out.print(a+", "));
    }
}
