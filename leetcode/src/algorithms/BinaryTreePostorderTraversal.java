package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * Difficulty : Hard
 * Related Topics : Stack, Tree, Depth-first Search
 *
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
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
public class BinaryTreePostorderTraversal {

    /**
     * Runtime: 0 ms
     * Memory Usage: 37.7 MB
     *
     * @param root
     * @return
     */
    // iterative
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> s = new Stack<>();
        //Stack<TreeNode> out = new Stack<>();

        s.push(root);

        while ( ! s.isEmpty()) {
            TreeNode currNode = s.pop();
            //if (currNode != null) out.push(currNode);
            if (currNode != null) result.add(0, currNode.val);
            if (currNode.left != null) s.push(currNode.left);
            if (currNode.right != null) s.push(currNode.right);
        }
        /*
        while ( ! out.isEmpty()) {
            TreeNode outNode = out.pop();
            result.add(outNode.val);
        }
        */
        return result;
    }

    // recursive pseudocode
/*
    postOrder(node)
        if (node == null)
            return

        postOrder(node.left)
        postOrder(node.right)
        visit(node)
*/
}
