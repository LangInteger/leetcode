package com.company.exercise;

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMapByValue = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int part = target - nums[i];
            if (indexMapByValue.containsKey(part)) {
                return new int[] {indexMapByValue.get(part), i};
            }
            indexMapByValue.put(nums[i], i);
        }
        return new int[] {};
    }
}
