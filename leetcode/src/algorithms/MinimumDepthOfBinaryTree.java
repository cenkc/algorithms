package algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Difficulty : Easy
 * Related Topics : Tree, Depth-first Search, Breadth-first Search
 *
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 * return its minimum depth = 2.
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
public class MinimumDepthOfBinaryTree {

    /**
     * Runtime: 0 ms
     * Memory Usage: 40.9 MB
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        // using BFS
        if (root == null) {
            return 0;
        }
        int level = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while ( ! q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) { // process each level
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) return level;
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            level++; // after processing the level, increment level counter
        }
        return level;
    }
}
