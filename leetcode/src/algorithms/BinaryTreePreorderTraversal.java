package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Difficulty : Medium
 * Related Topics : Stack, Tree, Depth-first Search
 *
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
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
public class BinaryTreePreorderTraversal {

    /**
     * Runtime: 0 ms
     * Memory Usage: 37.9 MB
     *
     * @param root
     * @return
     */
    // iterative
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> s = new Stack<>();
        s.push(root);

        while( ! s.isEmpty()) {
            TreeNode currNode = s.pop();

            if (currNode != null) result.add(currNode.val);

            // right child is pushed first so that left is processed first
            if (currNode.right != null) s.push(currNode.right);
            if (currNode.left != null) s.push(currNode.left);
        }
        return result;
    }

    // recursive pseudocode
/*
    preOrder(node)
        if (node == null)
            return

        visit(node)
        preOrder(node.left)
        preOrder(node.right)
*/
}
