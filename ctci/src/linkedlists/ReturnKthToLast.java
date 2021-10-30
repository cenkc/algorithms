package linkedlists;

import java.util.ArrayList;
import java.util.List;

/**
 * Return Kth To Last
 * https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2002.%20Linked%20Lists/Q2_02_Return_Kth_To_Last
 * Difficulty : Easy
 * Related Topics : Linked List
 *
 * created by Cenk Canarslan on 2021-10-30
 */
public class ReturnKthToLast {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(8);
        listNode.next.next.next = new ListNode(7);
        listNode.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next = new ListNode(3);

        // k=0 would return the last element, K=1 would return to the second to last element
        ListNode result = returnKthToLast(listNode, 3); // should return the node with val=8
        System.out.println("result.val = " + result.val);
    }

    /**
     * using ArrayList as an auxiliary data structure
     *
     * @param listNode
     * @param k
     * @return
     */
    private static ListNode returnKthToLast(ListNode listNode, int k) {
        List<ListNode> cup = new ArrayList<>();
        while (listNode != null) {
            cup.add(listNode);
            listNode = listNode.next;
        }
        return cup.get(cup.size() - 1 - k);
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private static void printLinkedList(ListNode listNode) {
        while (listNode != null) {
            System.out.println("listNode.val = " + listNode.val);
            listNode = listNode.next;
        }
    }
}
