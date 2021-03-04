package algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. Kth Smallest Element in a BST
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Difficulty : Medium
 * Related Topics : Binary Search, Tree
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 * Constraints:
 *
 * The number of elements of the BST is between 1 to 10^4.
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
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
public class KthSmallestElementInABST {

    private List<Integer> sortedList;

    /**
     * Runtime: 2 ms
     * Memory Usage: 43.4 MB
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        if (k == 0) return 0;

        sortedList = new ArrayList<>();

        inOrderTraverse(root, k);

        return sortedList.get(k - 1);
    }

    /**
     * if we traverse a BST with In-Order traversal (DFS), we'll get the data sorted
     */
    private void inOrderTraverse(TreeNode node, int k) {
        if (node.left != null) inOrderTraverse(node.left, k);
        if (node != null) sortedList.add(node.val);
        if (node.right != null) inOrderTraverse(node.right, k);
    }
}
