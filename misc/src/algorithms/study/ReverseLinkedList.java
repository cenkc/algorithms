package algorithms.study;

/**
 * Reverse a LinkedList
 *
 * created by cenkc on 5/10/2021
 */
public class ReverseLinkedList {

    private static ListNode head;

    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        rll.generateLinkedList();
        rll.printLinkedList(head);
        ListNode reversedLinkedList = rll.reverseLinkedList();
        rll.printLinkedList(reversedLinkedList);
    }

    private ListNode reverseLinkedList() {
        ListNode current = head;
        ListNode previous = null;

        while (current != null /*&& current.next != null*/) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    private void generateLinkedList() {
        for (int i = 0; i < 10; i++) {
            addToLast(new ListNode(i));
        }
    }

    private void addToLast(ListNode node) {
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    private void printLinkedList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println("val = " + temp.value);
            temp = temp.next;
        }
    }

/*
    private class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }
*/
}
