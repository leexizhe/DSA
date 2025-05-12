package answers.f_linked_list;

import static answers.f_linked_list.PrintLinkedList.printLinkedList;

public class F5RemoveNthNodeFromEnd {
    /**
     * Key Techniques:
     * ✅ Two-Pointer (Fast & Slow) → Finds nth node efficiently.
     * ✅ O(n) Time Complexity → Traverses the list once.
     * ✅ O(1) Space Complexity → Modifies list in place.
     *
     * Time Complexity: O(n)
     * We make a single pass through the linked list to find and remove the nth node.
     *
     * Space Complexity: O(1)
     * Since we modify pointers in place, we use constant extra space.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        // Step 1: Move fast pointer ahead by 'n' steps
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Step 2: Move both pointers until fast reaches the end
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Remove the nth node by skipping it
        slow.next = slow.next.next;

        return dummy.next; // Head remains unchanged
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printLinkedList(head);

        head = removeNthFromEnd(head, 2);

        System.out.println("List After Removing 2nd Node from End:");
        printLinkedList(head);
    }
}
