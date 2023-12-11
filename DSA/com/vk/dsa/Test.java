package com.vk.dsa;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Stream;

class Test {
    static Scanner in;

    public static void main(String[] args) {
        int t = 0;
        in = new Scanner(System.in);
        //t = in.nextInt();
        t = 1;
        while (t-- > 0) {
            solve();
        }
    }
    static void solve () {

        String [] sarr = {"A", "A", "B"};

        Supplier<StringBuilder> identity = StringBuilder::new;
        BiConsumer<StringBuilder, String> accumulator = (sb, s) -> sb.append(s);
        BiConsumer<StringBuilder, StringBuilder> combiner =  (sb1, sb2) -> sb1.append(sb2);

        StringBuilder res = Stream.of(sarr).parallel().collect(identity, accumulator, combiner);
        System.out.println(res);

    }

}
