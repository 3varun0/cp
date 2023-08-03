package com.vk.dsa.topic.recursion;

/**
 * print below pattern
 * 1
 * 12
 * 123
 * 1234
 * 12345
 */
public class Rec4_PatternPrint1 {
    public static void main(String[] args) {
        int n = 5;
        printPattern1(n);
    }

    private static void printPattern1(int n) {
        if (n == 0) {
            return;
        }
        printPattern1(n-1);
        for (int i=1; i<=n; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
