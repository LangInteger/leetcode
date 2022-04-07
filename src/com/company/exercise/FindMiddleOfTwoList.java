package com.company.exercise;

public class FindMiddleOfTwoList {
    public static void main(String[] args) {
        int[] arr1 = new int[] {1, 3};
        int[] arr2 = new int[] {2};
        FindMiddleOfTwoList procedure = new FindMiddleOfTwoList();
        double result = procedure.findMedianSortedArrays(arr1, arr2);
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;

        int length = length1 + length2;
        if (length == 1) {
            if (length1 == 1) {
                return nums1[0];
            } else {
                return nums2[0];
            }
        }

        int pos1;
        int pos2;
        boolean onlyPos2;
        if (length % 2 == 0) {
            // 取中间两个数
            onlyPos2 = false;
        } else {
            // 取中间一个数
            onlyPos2 = true;
        }

        // pos start from 1
        pos1 = length / 2;
        pos2 = length / 2 + 1;

        int count = 0;
        int point1 = 1;
        int point2 = 1;

        int num1 = 0;
        int num2 = 0;
        while (count < pos2 && point1 <= nums1.length && point2 <= nums2.length) {
            count ++;
            int curNum1 = nums1[point1 - 1];
            int curNum2 = nums2[point2 - 1];

            int choosen;
            if (curNum1 <= curNum2) {
                point1++;
                choosen = curNum1;
            } else {
                point2++;
                choosen = curNum2;
            }

            if (count == pos1) {
                num1 = choosen;
            }

            if (count == pos2) {
                num2 = choosen;
            }
        }

        if (point1 > nums1.length) {
            // loop point2 with nums2
            while (count < pos2) {
                count ++;
                int curNum = nums2[point2 - 1];
                if (count == pos1) {
                    num1 = curNum;
                }
                if (count == pos2) {
                    num2 = curNum;
                }
                point2++;
            }
        } else {
            // loop point1 with nums1
            while (count < pos2) {
                count ++;
                int curNum = nums1[point1 - 1];
                if (count == pos1) {
                    num1 = curNum;
                }
                if (count == pos2) {
                    num2 = curNum;
                }
                point1++;
            }
        }

        if (onlyPos2) {
            return num2;
        } else {
            return (num1 + num2) / (double) 2;
        }
    }
}
