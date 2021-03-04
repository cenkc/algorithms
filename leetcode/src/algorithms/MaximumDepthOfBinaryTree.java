package algorithms;

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Difficulty : Easy
 * Related Topics : Tree, Depth-first Search
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its depth = 3.
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
public class MaximumDepthOfBinaryTree {

    /**
     * Runtime: 0 ms
     * Memory Usage: 39.6 MB
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return calcMaxDepth(root);
    }

    private int calcMaxDepth(TreeNode root){
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(calcMaxDepth(root.left), calcMaxDepth(root.right));
    }
}
