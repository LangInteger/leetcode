package com.company.exercise;

import java.util.*;

public class NonRepeatSubStringLength {
    public static void main(String[] args) {
        NonRepeatSubStringLength procedure = new NonRepeatSubStringLength();
        procedure.lengthOfLongestSubstring("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {

        Map<Character, Integer> indexMapByChar = new HashMap<>();
        int curStartIndex = 0;
        int maxLen = 0;
        for (int index = 0; index < s.length(); index++) {
            if (indexMapByChar.containsKey(s.charAt(index))) {
                maxLen = getMaxLen(maxLen, curStartIndex, index);
                int oldStartIndex = curStartIndex;
                curStartIndex = indexMapByChar.get(s.charAt(index)) + 1;

                for (int i = oldStartIndex; i < curStartIndex; i++) {
                    indexMapByChar.remove(s.charAt(i));
                }
            } else {
                if (index == s.length() - 1) {
                    maxLen = getMaxLen(maxLen, curStartIndex, index + 1);
                }
            }

            indexMapByChar.put(s.charAt(index), index);
        }

        return maxLen;
    }

    private int getMaxLen(int maxLen, int curStartIndex, int index) {
        int curMaxLen = index - curStartIndex;

        if (curMaxLen > maxLen) {
            maxLen = curMaxLen;
        }
        return maxLen;
    }
}
