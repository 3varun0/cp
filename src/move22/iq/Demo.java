package move22.iq;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        //demo 1 : Write a program using java streams and check if no is prime or not

        /*
        Stream.of(4)

                .forEach(v -> {
                    boolean isPrime = true;
                    for (int i = 2; i<=v/2; i++) {
                        if (v%i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime) System.out.println("prime");
                    else System.out.println("not prime");
                });
         */


        //demo 2 : Using java streams (IntStream.range(1, 30))
        // find all the prime numbers for the given range and collect as map, where key=prime_number and value=some_incrementing_number
        AtomicInteger c = new AtomicInteger();
        Map<Integer, Integer> map = IntStream.range(1, 31)
                .filter(v -> {
                    boolean isPrime = true;
                    for (int i=2; i<=v/2; i++) {
                        if (v%i == 0) {
                            isPrime = false;
                            break;
                        }
                    }
                    if (isPrime) {
                        c.getAndIncrement();
                        return true;
                    } return false;
                })
                .boxed()
                .collect(Collectors.toMap(
                        v -> v,
                        v -> c.get()
                ));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key : "+entry.getKey()+ "  value : "+entry.getValue());
        }
    }
}
