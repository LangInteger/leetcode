package com.company.exercise;

import java.util.Deque;
import java.util.LinkedList;

public class _101IsSymmetric {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return doIsSymmetric(root, root);
    }

    private boolean doIsSymmetric(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && doIsSymmetric(p.left, q.right) && doIsSymmetric(p.right, q.left);
    }
}
