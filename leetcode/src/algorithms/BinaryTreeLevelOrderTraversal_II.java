package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * Difficulty : Easy
 * Related Topics : Tree, Breadth-first Search
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
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
 * created by cenkc on 8/25/2020
 */
public class BinaryTreeLevelOrderTraversal_II {

    /**
     * Runtime: 2 ms, faster than 44.77% of Java online submissions for Binary Tree Level Order Traversal II.
     * Memory Usage: 40.3 MB, less than 45.37% of Java online submissions for Binary Tree Level Order Traversal II.
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while ( ! q.isEmpty()) {
            int size = q.size();
            List<Integer> innerList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                innerList.add(current.val);
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
            result.add(0, innerList);
        }
        return result;
    }
}
