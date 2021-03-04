package algorithms;

/**
 * 938. Range Sum of BST
 * https://leetcode.com/problems/range-sum-of-bst/
 * Difficulty : Easy
 * Related Topics : Tree, Recursion
 *
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 *
 *
 * Note:
 *
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
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
public class RangeSumOfBST {

// in order (DFS)
// Runtime: 1 ms, faster than 54.69% of Java online submissions for Range Sum of BST.
// Memory Usage: 62.3 MB, less than 5.04% of Java online submissions for Range Sum of BST.

    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        int sum = 0;
        //in order, LNR
        return dfsTraversal(root, sum, L, R);
    }

    private int dfsTraversal(TreeNode node, int sum, int L, int R) {
        if (node.left != null) sum = dfsTraversal(node.left, sum, L, R);
        sum += (node != null && L <= node.val && node.val <= R ? node.val : 0);
        if (node.right != null) sum = dfsTraversal(node.right, sum, L, R);
        return sum;
    }


/*
// level order (BFS)
// Runtime: 23 ms, faster than 5.02% of Java online submissions for Range Sum of BST.
// Memory Usage: 68.7 MB, less than 5.04% of Java online submissions for Range Sum of BST.
class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while ( ! q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null && L <= node.val && node.val <= R) {
                sum += node.val;
            }
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }
        return sum;
    }
}
*/
}
