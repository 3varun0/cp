package com.vk.dsa.topic.recursion;

/**
 * This problem is to print below pattern
 * 12345
 * 1234
 * 123
 * 12
 * 1
 * 12
 * 123
 * 1234
 * 12345
 * */
public class Rec5_PatternPrint2 {
    public static void main(String[] args) {
        int n = 5;
        printPattern2(n);
    }

    private static void printPattern2(int n) {
        if (n == 0) {
            return;
        }
        if (n == 1) {
            System.out.println(n);
            return;
        }
        for (int i=1; i<=n; i++) {
            System.out.print(i+" ");
        }
        System.out.println();

        printPattern2(n-1);

        for (int i=1; i<=n; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
