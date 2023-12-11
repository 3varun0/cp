package com.vk.dsa.topic.recursion;

public class Rec0_PrintHelloNTimes {

    public static void main(String[] args) {
        printHello(10);
    }

    private static void printHello(int n) {
        if (n == 0) {
            return;
        }

        printHello(n-1);

        System.out.println("Hello "+n);
    }
}
