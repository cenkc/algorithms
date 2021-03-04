package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Difficulty : Medium
 * Related Topics : HashTable, Stack, Tree
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 * created by cenkc on 8/12/2020
 */
public class BinaryTreeInorderTraversal {

    // iterative
// Runtime: 1 ms, faster than 29.43% of Java online submissions for Binary Tree Inorder Traversal.
// Memory Usage: 39.4 MB, less than 5.05% of Java online submissions for Binary Tree Inorder Traversal.
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Stack<TreeNode> s = new Stack<>();

        while ( ! s.isEmpty() || root != null) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }

/*
// recursive
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
// Memory Usage: 38 MB, less than 8.81% of Java online submissions for Binary Tree Inorder Traversal.

    private List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return result;
        inOrderTraverse(root);
        return result;
    }

    private void inOrderTraverse(TreeNode node) {
        if (node.left != null) inOrderTraverse(node.left);
        if (node != null) result.add(node.val);
        if (node.right != null) inOrderTraverse(node.right);
    }
*/
}
