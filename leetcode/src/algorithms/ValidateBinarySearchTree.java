package algorithms;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Difficulty : Medium
 * Related Topics : Tree, Depth-first Search
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *
 * created by cenkc on 8/12/2020
 */
public class ValidateBinarySearchTree {

    /**
     * Runtime: 1 ms
     * Memory Usage: 39.2 MB
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        // in order (DFS)
        Stack<TreeNode> s = new Stack<>();
        double check = - Double.MAX_VALUE;

        while ( ! s.isEmpty() || root != null) {
            while (root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if (root.val <= check) {
                return false;
            }
            check = root.val;
            root = root.right;
        }
        return true;
    }
}
