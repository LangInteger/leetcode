package com.company.exercise;

public class MaxArea {
    public int maxAreaNPowerTwo(int[] height) {
        int maxArea = 0;
        for (int index = 0; index < height.length - 1; index++) {
            for (int secondIndex = index + 1; secondIndex < height.length; secondIndex++) {
                int area = (secondIndex - index) * Math.min(height[index], height[secondIndex]);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    /**
     * x 是当前左指针；y 是当前右指针；t 为其间距
     * area = min(x, y) * t
     * - 如果 x <= y，那么无论右指针在那里，这个容器的容量都不会超过 x * t
     * - 即移动 右指针对面积变大是没有意义的,即每次移动指向数字值较小的的那个指针即可
     */
    public int maxArea(int[] height) {
        int leftIndex = 0;
        int rightIndex = height.length - 1;

        int maxArea = 0;
        while (leftIndex < rightIndex) {
            int cur = (rightIndex - leftIndex) * Math.min(height[leftIndex], height[rightIndex]);
            maxArea = Math.max(maxArea, cur);

            if (height[leftIndex] <= height[rightIndex]) {
                leftIndex = leftIndex + 1;
            } else {
                rightIndex = rightIndex - 1;
            }
        }

        return maxArea;
    }
}
