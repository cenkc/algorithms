package linkedlists;

import java.util.HashSet;

/**
 * ZeroMatrix
 * https://github.com/careercup/CtCI-6th-Edition/tree/master/Java/Ch%2002.%20Linked%20Lists/Q2_01_Remove_Dups
 * Difficulty : Easy
 * Related Topics : Array, String
 *
 * created by Cenk Canarslan on 2021-10-26
 */
public class RemoveDups {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5);
        listNode.next = new ListNode(3);
        listNode.next.next = new ListNode(8);
        listNode.next.next.next = new ListNode(5);
        listNode.next.next.next.next = new ListNode(9);
        listNode.next.next.next.next.next = new ListNode(3);

        printLinkedList(listNode);
//        removeDuplicate(listNode);
        removeDuplicateWithoutBuffer(listNode);
        System.out.println("----------");
        printLinkedList(listNode);
    }

    private static void removeDuplicate(ListNode listNode) {
        if (listNode == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode previous = null;
        while (listNode != null) {
            if (set.contains(listNode.val)) {
                previous.next = listNode.next;
            } else {
                set.add(listNode.val);
                previous = listNode;
            }
            listNode = listNode.next;
        }
    }

    private static void removeDuplicateWithoutBuffer(ListNode listNode) {
        ListNode curr = listNode;
        while (curr != null) {
            ListNode fasterNode = curr;
            while (fasterNode.next != null) {
                if (fasterNode.next.val == curr.val) {
                    fasterNode.next = fasterNode.next.next;
                } else {
                    fasterNode = fasterNode.next;
                }
            }
            curr = curr.next;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

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
