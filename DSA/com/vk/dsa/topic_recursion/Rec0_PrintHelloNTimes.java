package com.vk.dsa.topic_recursion;

public class Rec0_PrintHelloNTimes {

    public static void main(String[] args) {
        printHello(10);
    }

    private static void printHello(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("Hello "+n);
        printHello(n-1);
    }
}
