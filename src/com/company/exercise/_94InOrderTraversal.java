package com.company.exercise;

import java.util.*;

public class _94InOrderTraversal {

    private List<Integer> nodes = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        doTraverse(root);
        return nodes;
    }

    private void doTraverse(TreeNode node) {
        if (node == null) {
            return;
        }

        doTraverse(node.left);
        nodes.add(node.val);
        doTraverse(node.right);
    }

    //=======================

    public List<Integer> inorderTraversal1(TreeNode root) {
       List<Integer> nodes = new ArrayList<>();
       Deque<TreeNode> stack = new LinkedList<>();

       while (root != null || !stack.isEmpty()) {
           while (root != null) {
               stack.push(root);
               root = root.left;
           }
           root = stack.pop();
           nodes.add(root.val);
           root = root.right;
       }
       return nodes;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
