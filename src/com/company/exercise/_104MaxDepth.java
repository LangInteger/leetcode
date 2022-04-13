package com.company.exercise;

import com.sun.source.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class _104MaxDepth {
    public int maxDepthNormal(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int countCurLevel = 1;
        int countNextLevel = 0;
        int depth = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            countCurLevel --;

            if (node.left != null) {
                countNextLevel ++;
                queue.add(node.left);
            }

            if (node.right != null) {
                countNextLevel ++;
                queue.add(node.right);
            }

            if (countCurLevel == 0) {
                depth ++;
                countCurLevel = countNextLevel;
                countNextLevel = 0;
            }
        }

        return depth;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
