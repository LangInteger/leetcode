package com.company.exercise;

public class _70ClimbStairs {

    public int count = 0;

    public int climbStairs(int n) {
        doClimb(n);
        return count;
    }

    public void doClimb(int n) {
        if (n == 0) {
            count = count + 1;
            return;
        }

        if (n >= 2) {
            doClimb(n - 2);
        }

        doClimb(n - 1);
    }

    //============================
    public int climb(int n) {
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return 1;
        }

        int lastLast = 1;
        int last = 1;
        int cur = 2;
        for (int index = 2; index <= n; index++) {
            cur = last + lastLast;
            lastLast = last;
            last = cur;
        }

        return cur;
    }
}
