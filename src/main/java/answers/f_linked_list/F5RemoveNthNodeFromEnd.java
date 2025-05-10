package answers.f_linked_list;

import static answers.f_linked_list.PrintLinkedList.printLinkedList;

public class F5RemoveNthNodeFromEnd {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of nodes in the linked list.
     * We make a single pass to find the length and another pass to remove the nth node, resulting in O(n).
     *
     * Space Complexity: O(1)
     * The space complexity is O(1), since we only use a few pointers and do not allocate additional data structures.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); // Dummy node to handle edge cases
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        // Move fast ahead by n+1 steps to create a gap
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        // Move both slow and fast until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end
        slow.next = slow.next.next;

        return dummy.next; // Return the new head
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printLinkedList(head);

        head = removeNthFromEnd(head, 2); // Remove 2nd node from end

        System.out.println("Updated List:");
        printLinkedList(head);
    }
}
