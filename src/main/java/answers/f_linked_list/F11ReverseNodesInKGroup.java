package answers.f_linked_list;

import static answers.f_linked_list.PrintLinkedList.printLinkedList;

public class F11ReverseNodesInKGroup {
    /**
     * Key Techniques:
     * ✅ Iterative Reverse → Reverses nodes within each k-group.
     * ✅ Recursion → Handles remaining sublists efficiently.
     * ✅ O(n) Time Complexity → Traverses and modifies nodes once.
     *
     * Time Complexity: O(n)
     * We iterate through the linked list once, reversing k-sized groups efficiently.
     *
     * Space Complexity: O(1)
     * Modifies nodes in-place without extra memory allocation.
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode start = prevGroupEnd.next;
            ListNode end = prevGroupEnd;

            // Step 1: Move end pointer k steps forward
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break; // Not enough nodes left to reverse

            ListNode nextGroupStart = end.next;
            end.next = null; // Temporarily break the list

            // Step 2: Reverse current k-group
            prevGroupEnd.next = reverseList(start);
            start.next = nextGroupStart;

            // Step 3: Move prevGroupEnd forward for next iteration
            prevGroupEnd = start;
        }

        return dummy.next;
    }

    /**
     * Helper Function to Reverse a Linked List
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printLinkedList(head);

        head = reverseKGroup(head, 2);

        System.out.println("Reversed List in k-Groups:");
        printLinkedList(head);
    }
}
