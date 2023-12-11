package com.vk.dsa.topic.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindTargetInArray {

    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums.length-1;
        int ans = -1;
        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (check(mid, nums, target) == 1) {
                ans = mid;
                list.add(ans);
                int left = ans-1;
                while(left >= 0 && nums[left] == target) {
                    list.add(left--);
                }
                int right = ans+1;
                while (right <= nums.length-1 && nums[right] == target){
                    list.add(right++);
                }
                break;
            } else if (target < nums[mid]) {
                hi = mid-1;
            } else if (target > nums[mid]) {
                lo = mid+1;
            }
        }
        Collections.sort(list);
        return list;
    }

    int check (int x, int []nums, int target) {
        if (nums[x] == target) return 1;
        else return 0;

    }
}
