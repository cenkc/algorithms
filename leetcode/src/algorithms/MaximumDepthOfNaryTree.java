package algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 559. Maximum Depth of N-ary Tree
 * https://leetcode.com/problems/maximum-depth-of-n-ary-tree/
 * Difficulty : Easy
 * Related Topics : Depth-first Search, Breadth-first Search
 *
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 *
 *
 *
 * Example 1:
 * https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 *
 * Example 2:
 * https://assets.leetcode.com/uploads/2019/11/08/sample_4_964.png
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 5
 *
 *
 * Constraints:
 *
 * The depth of the n-ary tree is less than or equal to 1000.
 * The total number of nodes is between [0, 10^4].
 *
 *
 * // Definition for a Node.
 * class Node {
 *     public int val;
 *     public List<Node> children;
 *
 *     public Node() {}
 *
 *     public Node(int _val) {
 *         val = _val;
 *     }
 *
 *     public Node(int _val, List<Node> _children) {
 *         val = _val;
 *         children = _children;
 *     }
 * };
 *
 * created by cenkc on 8/12/2020
 */
public class MaximumDepthOfNaryTree {

    /**
     * Runtime: 1 ms
     * Memory Usage: 40.2 MB
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int level = 0;
        while ( ! q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node currNode = q.poll();
                List<Node> children = currNode.children;
                for (Node child : children) {
                    q.offer(child);
                }
            }
            level++;
        }
        return level;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
