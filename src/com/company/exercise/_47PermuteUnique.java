package com.company.exercise;

import java.util.*;

public class _47PermuteUnique {

    class MyList<R> extends LinkedList<R> {
        public MyList(LinkedList<R> list) {
            super(list);
        }

        public boolean equals(Object obj) {
            MyList<R> newObj = (MyList<R>) obj;
            if (newObj.size() != this.size()) {
                return false;
            }

            for (int index = 0; index < newObj.size(); index++) {
                if (newObj.get(index) != this.get(index)) {
                    return false;
                }
            }

            return true;
        }
    }

    private LinkedList<LinkedList<Integer>> result = new LinkedList<>();
    private Set<MyList<Integer>> existed = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        return null;
    }

    private void backTrace(int[] nums, MyList<Integer> track) {
        if (track.size() == nums.length) {
            if (existed.contains(track)) {
                return;
            } else {
                LinkedList<Integer> cur = new LinkedList<>(track);
                result.addLast(cur);
                existed.add(new MyList<>(cur));
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (track.contains(nums[index])) {
                continue;
            } else {
                track.addLast(nums[index]);
                backTrace(nums, track);
                track.removeLast();
            }
        }
    }

}
