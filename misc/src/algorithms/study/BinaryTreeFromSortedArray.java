package algorithms.study;

/**
 * created by Cenk Canarslan on 2021-05-08
 */
public class BinaryTreeFromSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,7,9,13};

        BinaryTreeFromSortedArray btfsa = new BinaryTreeFromSortedArray();
        MyTreeNode myTreeNode = btfsa.generateBinaryTree(arr);
        System.out.println("test");

        btfsa.printTree(myTreeNode);
    }

    private void printTree(MyTreeNode myTreeNode) {
        postOrderRecursive(myTreeNode);
    }

    /**
     * Left Node, Right Node, Root Node
     * @param node
     */
    private void postOrderRecursive(MyTreeNode node) {
        if (node == null) {
            return;
        }
        postOrderRecursive(node.left);
        postOrderRecursive(node.right);
        System.out.println("-" + node.value);
    }

    private MyTreeNode generateBinaryTree(int[] arr) {
        MyTreeNode root = null;
        for(int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        return root;
    }

    private MyTreeNode insert(MyTreeNode root, int value) {
        if (root == null) {
            return new MyTreeNode(value);
        }
        if (value < root.value) {
            root.left = insert(root.left, value);
        } else if (value > root.value) {
            root.right = insert(root.right, value);
        } else {
            root.value = value;
        }
        return root;
    }

    private class MyTreeNode {
        int value;
        MyTreeNode left;
        MyTreeNode right;

        public MyTreeNode(int value) {
            this.value = value;
        }
        public MyTreeNode(int value, MyTreeNode left, MyTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
