package answers.f_linked_list;

import static answers.f_linked_list.PrintLinkedList.printLinkedList;

public class F4ReorderLinkedList {
    /**
     * Key Techniques:
     * ✅ Fast & Slow Pointers → Efficiently finds the middle of the list.
     * ✅ Reverse Second Half → Prepares for alternating merge.
     * ✅ Merge Two Lists → Rearranges in required order.
     *
     * Time Complexity: O(n)
     * We traverse the list multiple times (finding middle, reversing, merging), but all operations are linear.
     *
     * Space Complexity: O(1)
     * We modify the linked list in place, requiring no extra memory.
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the linked list using slow-fast pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        ListNode prev = null, curr = slow.next;
        slow.next = null; // Break the list into two halves
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // Step 3: Merge first and reversed second half alternately
        ListNode first = head, second = prev;
        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printLinkedList(head);

        reorderList(head);

        System.out.println("Reordered List:");
        printLinkedList(head);
    }
}
