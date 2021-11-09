package algorithms;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

/**
 * 124. Binary Tree Maximum Path Sum
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * Difficulty : Hard
 * Related Topics : Dynamic Programming, Tree, Depth-First Search, Binary Tree
 *
 * A path in a binary tree is a sequence of nodes where each pair of
 * adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once.
 * Note that the path does not need to pass through the root.
 *
 * The path sum of a path is the sum of the node's values in the path.
 *
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 * Example 1:
 *          1
 *         / \
 *        2   3
 *
 * Input: root = [1,2,3]
 * Output: 6
 * Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
 *
 * Example 2:
 *         -10
 *         /  \
 *       9     20
 *            /  \
 *         15     7
 *
 * Input: root = [-10,9,20,null,null,15,7]
 * Output: 42
 * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 *
 *
 created by Cenk Canarslan on 2021-11-09
 */
public class BinaryTreeMaxPathSum {

    int result = Integer.MIN_VALUE;

    @Test
    public void testBinaryTreeMaxPathSum() {

        // root = [1,2,3]
        // (root, root.left, root.right)
        TreeNode root = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        );
        assertEquals(6, maxPathSum(root));

        // root = [-10,9,20,null,null,15,7]
        // (root, root.left, root.right, root.left.left, root.left.right, root.right.left, root.right.right)
        root = new TreeNode(
                -10,
                new TreeNode(9),
                new TreeNode(
                    20,
                    new TreeNode(15),
                    new TreeNode(7)
                )
        );
        assertEquals(42, maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = root.val;
        calculate(root);
        return result;
    }

    private int calculate(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftTotal = calculate(node.left);
        int rightTotal = calculate(node.right);
        leftTotal = leftTotal > 0 ? leftTotal : 0;
        rightTotal = rightTotal > 0 ? rightTotal : 0;
        int currMax = node.val + leftTotal + rightTotal;
        result = Math.max(result, currMax);
        return node.val + Math.max(leftTotal, rightTotal);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

/*
    public int inOrderTraversal(TreeNode root) {
        if (root == null) return -1;
        int result = 0;
        Stack<TreeNode> s = new Stack<>();
        while ( ! s.isEmpty() || root != null ) {
            if (root != null) {
                s.push(root);
                root = root.left;
            } else {
                root = s.pop();
                result += root.val;
                root = root.right;
            }
        }
        return result;
    }
*/
}
