package com.company.exercise;

import java.util.*;

public class _102LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        int countCurLevel = 1;
        int countNextLevel = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curLevel = new ArrayList<>();
        while (!list.isEmpty()) {
            TreeNode node = list.pollFirst();
            curLevel.add(node.val);
            countCurLevel = countCurLevel - 1;
            if (node.left != null) {
                list.addLast(node.left);
                countNextLevel = countNextLevel + 1;
            }
            if (node.right != null) {
                list.addLast(node.right);
                countNextLevel = countNextLevel + 1;
            }

            if (countCurLevel == 0) {
                result.add(curLevel);
                curLevel = new ArrayList<>();
                countCurLevel = countNextLevel;
                countNextLevel = 0;
            }
        }

        return result;
    }
}
