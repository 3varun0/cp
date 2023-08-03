package com.vk.dsa.topic.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;

public class Problem2_SlidingWindowMaximum {

    // function to clean up the window
    public static ArrayList<Integer> cleanUp(int i, ArrayList<Integer> currentWindow, int[] nums) {
        // remove all the indexes from currentWindow whose corresponding values are smaller than or equal to the current element
        while (currentWindow.size() != 0 && nums[i] >= nums[currentWindow.get(currentWindow.size() - 1)]) {
            currentWindow.remove(currentWindow.size() - 1);
        }

        // returning the altered currentWindow
        return currentWindow;
    }

    // function to find the maximum in all possible windows
    public static int[] findMaxSlidingWindow(int[] nums, int w) {
        // if the input array is empty, return an empty array
        if (nums.length == 0) {
            return new int[0];
        }

        // if window size is greater than the array size, set the window size to the array size
        if (w > nums.length) {
            w = nums.length;
        }

        // initializing variables
        int [] output = new int[nums.length - w + 1];
        ArrayList<Integer> currentWindow = new ArrayList<Integer> ();


        // iterate over the first w elements
        for (int i = 0; i < w; i++) {

            // for every element, remove the previous smaller elements from currentWindow
            currentWindow = Problem2_SlidingWindowMaximum.cleanUp(i, currentWindow, nums);

            // append the index of the current element to currentWindow
            currentWindow.add(i);
        }

        // appending the maximum element of the current window to the output list
        output[0] = nums[currentWindow.get(0)];

        // iterate over the remaining input list
        for (int i = w; i < nums.length; i++) {

            // for every element, remove the previous smaller elements from currentWindow
            cleanUp(i, currentWindow, nums);

            // remove first index from the currentWindow if it has fallen out of the current window
            if (!currentWindow.isEmpty() && currentWindow.get(0) <= (i - w)) {
                currentWindow.remove(0);
            }

            // append the index of the current element to currentWindow
            currentWindow.add(i);

            // adding the maximum element of the current window to the output list
            output[i - w + 1] = nums[currentWindow.get(0)];
        }

        // return the array containing output
        return output;
    }

    // driver code
    public static void main(String args[]) {
        int windowSizes [] = {3, 3, 3, 3, 2, 4, 3, 2, 3, 18};
        int [][] numLists = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                {1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30},
                {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
                {4, 5, 6, 1, 2, 3},
                {9, 5, 3, 1, 6, 3},
                {2, 4, 6, 8, 10, 12, 14, 16},
                {-1, -1, -2, -4, -6, -7},
                {4, 4, 4, 4, 4, 4}
        };

        for (int i = 0; i < numLists.length; i++) {
            System.out.println("\n\tMaximum in each sliding window:\t" + Arrays.toString(findMaxSlidingWindow(numLists[i], windowSizes[i])));
            System.out.println();
        }
    }
}