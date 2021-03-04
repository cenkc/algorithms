package algorithms;

import java.util.*;

/**
 * 501. Find Mode in Binary Search Tree
 * https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * Difficulty : Easy
 * Related Topics : Tree
 *
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
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
public class FindModeInBinarySearchTree {

    public int[] findMode(TreeNode root) {
//        if (root == null) {
//            return null;
//        }
        Queue<TreeNode> q = new LinkedList<>();
        Map<Integer, Integer> counters = new HashMap<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        while ( ! q.isEmpty()) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode node = q.poll();
                if (node != null) {
                    counters.put(node.val, counters.getOrDefault(node.val, 0) + 1);
                    max = Math.max(max, counters.get(node.val));
                    if (node.left != null) {
                        q.add(node.left);
                    }
                    if (node.right != null) {
                        q.add(node.right);
                    }
                }
            }

        }
        List<Integer> resultList = new ArrayList<>();
        for (int key : counters.keySet()) {
            if (counters.get(key) == max) {
                resultList.add(key);
            }
        }

        int[] resultArray = new int[resultList.size()];
        int i = 0;
        for (int key : resultList) {
            resultArray[i] = key;
            i++;
        }
        return resultArray;
    }
}
