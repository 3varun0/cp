package com.vk.dsa.topic_slidingwindow;

import java.util.*;

public class Problem1_RepeatedDNASequence {

    public List<String> findRepeatedDnaSequences(String s) {
        //given in problem desc, k = 10
        int k = 10;

        int n = s.length();

        //mapping table for hashing
        Map<Character, Integer> mapping = new HashMap<>();
        mapping.put('A', 1);
        mapping.put('C', 2);
        mapping.put('G', 3);
        mapping.put('T', 4);

        //taking base as 4, since DNA has only four nucleotides
        int base = 4;

        //Corresponding hash values
        List<Integer> numbers = Arrays.asList(new Integer[n]);
        Arrays.fill(numbers.toArray(), 0);
        for (int i=0; i<n; i++) {
            numbers.set(i, mapping.get(s.charAt(i)));
        }

        int hashValue = 0;
        Set<String> output = new HashSet<>();
        Set<Integer> hashSet = new HashSet<>();
        int wStart = 0;
        for (int wEnd = 0; wEnd < n-k+1; wEnd++) {
            if (wEnd == 0) {

                for (int j = 0; j<k; j++) {
                    wStart = numbers.get(j) * (int)Math.pow(base, k-j-1);
                    hashValue = hashValue + wStart;
                }

            } else {
                int prevHashValue = hashValue;
                wStart = numbers.get(wEnd-1) * (int)Math.pow(base, k-1);
                prevHashValue = prevHashValue - wStart;
                //shifting the remaining bases to the left one position, so that hash corresponds to new window.
                prevHashValue = prevHashValue * base;
                //sliding window
                hashValue = prevHashValue + numbers.get(wEnd+k-1) * (int)Math.pow(base, 0);
            }

            if (hashSet.contains(hashValue)) {
                output.add(s.substring(wEnd, wEnd+k));
            }

            hashSet.add(hashValue);
        }

        return new ArrayList<>(output);

    }
}