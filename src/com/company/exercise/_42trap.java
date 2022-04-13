package com.company.exercise;

public class _42trap {

    /**
     * 雨水 of every point = min(leftMaxHeight,rightMaxHeight) - cur
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int[] leftMaxHeight = new int[height.length];
        int leftMax = height[0];
        for (int index = 0; index < height.length; index++) {
            leftMaxHeight[index] = leftMax;
            if (height[index] > leftMax) {
                leftMax = height[index];
            }
        }

        int[] rightMaxHeight = new int[height.length];
        int rightMax = height[height.length - 1];
        for (int index = height.length - 1; index >= 0; index--) {
            rightMaxHeight[index] = rightMax;
            if (height[index] > rightMax) {
                rightMax = height[index];
            }
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum = sum + Math.max(Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i], 0);
        }

        return sum;
    }
}
