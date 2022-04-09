package com.company.exercise;

public class RemoveDuplicatesInArray {

    /**
     * 1 1 2 2
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int slowPointer = 0;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == nums[index - 1]) {
                // do nothing
            } else {
                slowPointer = slowPointer + 1;
                nums[slowPointer] = nums[index];
            }
        }

        return slowPointer + 1;
    }
}
