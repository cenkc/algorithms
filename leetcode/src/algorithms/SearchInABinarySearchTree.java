package algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 700. Search in a Binary Search Tree
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 * Difficulty : Easy
 * Related Topics : Tree
 *
 * Given the root node of a binary search tree (BST) and a value.
 * You need to find the node in the BST that the node's value equals the given value.
 * Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 *
 * For example,
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * And the value to search: 2
 * You should return this subtree:
 *
 *       2
 *      / \
 *     1   3
 * In the example above, if we want to search the value 5,
 * since there is no node with value 5, we should return NULL.
 *
 * Note that an empty tree is represented by NULL,
 * therefore you would see the expected output (serialized tree format) as [], not null.
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
public class SearchInABinarySearchTree {

    /**
     * Runtime: 17 ms
     * Memory Usage: 52.6 MB
     *
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Map<Integer, TreeNode> map = new HashMap<>();

        while( ! q.isEmpty()) {
            TreeNode node = q.poll();
/*
            int tmpVal = node.val;
            if (tmpVal == val) {
                if (node.left == null && node.right == null) {
                    return null;
                } else {
                    return node;
                }
            }
*/
            map.put(node.val, node);
            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        TreeNode returnNode = map.get(val);
        return returnNode;
    }
}
