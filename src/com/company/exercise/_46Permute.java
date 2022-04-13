package com.company.exercise;

import java.util.*;

public class _46Permute {

    private List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrace(nums, track);
        return result;
    }

    public void backTrace(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            result.add(new LinkedList<>(track));
            return;
        }

        for (int index = 0; index < nums.length; index++) {
            if (!track.contains(nums[index])) {
                track.addLast(nums[index]);
                backTrace(nums, track);
                track.removeLast();
            } else {
                continue;
            }
        }
    }

}
