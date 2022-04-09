package com.company.exercise;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring procedure = new LongestPalindromicSubstring();
        String result = procedure.longestPalindrome("babad");
        System.out.println(result);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxSubString = s.substring(0, 1);

        int leftLimit = 0;
        int rightLimit = s.length() - 1;
        for (int index = 0; index < s.length(); index ++) {
            int left = index - 1;
            int right = index + 1;
            while (left >= leftLimit && right <= rightLimit) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (left == leftLimit || right == rightLimit) {
                        // (right - 1) - (left + 1) + 1;
                        int curLen = right - left - 1;
                        if (curLen > maxLen) {
                            maxLen = curLen;
                            maxSubString = s.substring(left + 1, right);
                        }
                    }
                } else {
                    // (right - 1) - (left + 1) + 1;
                    int curLen = right - left - 1;
                    if (curLen > maxLen) {
                        maxLen = curLen;
                        maxSubString = s.substring(left + 1, right);
                    }
                }

                left --;
                right ++;
            }
        }

        for (int index = 0; index < s.length(); index ++) {
            int left = index;
            int right = index + 1;
            while (left >= leftLimit && right <= rightLimit) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (left == leftLimit || right == rightLimit) {
                        maxLen = s.length();
                        maxSubString = s;
                    }
                } else {
                    // (right - 1) - (left + 1) + 1;
                    int curLen = right - left - 1;
                    if (curLen > maxLen) {
                        maxSubString = s.substring(left + 1, right);
                    }
                }

                left --;
                right ++;
            }
        }
        return maxSubString;
    }
}
