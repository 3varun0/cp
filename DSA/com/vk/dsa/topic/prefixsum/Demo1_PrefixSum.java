package com.vk.dsa.topic.prefixsum;

public class Demo1_PrefixSum {

    public static void main(String[] args) {
        int []arr = {4,2,3,1,-5,6};
        int l = 1;
        int r = 5;
        int []p = new int [arr.length];
        //creating prefix-sum array
        for (int i=0; i<arr.length; i++) {
            p[i] = arr[i];
            if (i != 0) {
                p[i] += p[i-1];
            }
        }
        //prefix-sum array is ready now

        int ans = p[r] - (l>0?p[l-1]:0);
        System.out.println(ans);
    }

}
