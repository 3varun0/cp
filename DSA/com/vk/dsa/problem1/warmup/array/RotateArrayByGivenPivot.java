package com.vk.dsa.problem1.warmup.array;

public class RotateArrayByGivenPivot {

    public static void main(String[] args) {

        int []arr = {1,2,3,4,5,6,7};
        int pivot = 3;
        //approach1InMemoryRotation(arr);
        //approach2ByTakingExtraArray(arr, pivot);
        //approach3ByTakingPivotSizedExtraArray(arr, pivot);
        approach4UsingTwoPointersAlgo(arr, pivot);


    }

    /**
     * This apprach uses two pointers algorithm and does not use any extra array.
     * @param arr
     * @param pivot
     */
    private static void approach4UsingTwoPointersAlgo(int[] arr, int pivot) {
        System.out.println("approach 4");
        System.out.print("Printing Original array : ");
        printArray(arr);

        int left = 0;
        int right = pivot-1;
        int temp = 0;

        //reversing left subarray
        for (int i=0; i<pivot; i++) {
            if (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        //reversing right subarray
        left = pivot;
        right = arr.length-1;
        for (int i=pivot; i<arr.length; i++) {
            if (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        left = 0;
        right = arr.length - 1;
        for (int i=0; i<arr.length; i++) {
            if (left < right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        System.out.print("Printing rotated array : ");
        printArray(arr);
    }

    /**
     * In this approach, we use a pivot and extra small array for storage of size of pivot.
     * @param arr
     * @param pivot
     */
    private static void approach3ByTakingPivotSizedExtraArray(int[] arr, int pivot) {
        System.out.println("approach 3");
        System.out.print("Printing original array : ");
        printArray(arr);

        int []arr2 = new int[pivot];
        for (int i=0; i<pivot; i++) {
            arr2[i] = arr[i];
        }
        //rotation 1
        int j=0;
        for (int i=pivot; i<arr.length; i++) {
            arr[j++] = arr[i];
        }

        //rotation 2
        for (int i=0; i<arr2.length; i++) {
            arr[j++] = arr2[i];
        }

        System.out.print("Printing rotated array : ");
        printArray(arr);
    }

    /**
     * In this approach, we use a given pivot & a extra array for rotating
     * @param arr
     * @param pivot
     */
    private static int[] approach2ByTakingExtraArray(int[] arr, int pivot) {
        System.out.println("approach 2");
        System.out.print("Printing original array : ");
        printArray(arr);
        int [] arr2 = new int[arr.length];
        int j=0;
        for (int i=pivot; i<arr.length; i++) {
            arr2[j++] = arr[i];
        }
        for (int i=0; i<pivot; i++) {
            arr2[j++] = arr[i];
        }
        System.out.print("Printing rotated array : ");
        printArray(arr2);
        return arr2;
    }

    /**
     * approach 1
     * in memory rotation using temp variable
     * this is only for the case, when only the right most element is to be rotated to left most side.
     */
    private static void approach1InMemoryRotation(int[] arr) {
        System.out.println("approach 1");
        System.out.print("Printing original array : ");
        printArray(arr);
        int temp = arr[0];
        for (int i=1; i<arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = temp;
        System.out.print("Printing rotated array : ");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i+", ");
        }
        System.out.println();
    }

}
