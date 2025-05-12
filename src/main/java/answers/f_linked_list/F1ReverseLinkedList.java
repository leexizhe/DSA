package answers.f_linked_list;

import static answers.f_linked_list.PrintLinkedList.printLinkedList;

public class F1ReverseLinkedList {
    /**
     * Key Techniques:
     * ✅ Iterative Approach → Simple and easy to understand.
     * ✅ O(n) Time Complexity → Efficiently traverses and modifies the list.
     * ✅ O(1) Space Complexity → No extra memory usage.
     *
     * Time Complexity: O(n)
     * We iterate through the linked list exactly once, making it linear in time.
     *
     * Space Complexity: O(1)
     * We reverse the list in place, requiring no additional memory.
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode next = current.next; // Store the next node
            current.next = prev; // Reverse the pointer
            prev = current; // Move prev forward
            current = next; // Move current forward
        }

        return prev; // New head of the reversed list
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode list2 = new ListNode(1, new ListNode(2));
        ListNode list3 = new ListNode(1);

        printLinkedList(reverseList(list1));
        printLinkedList(reverseList(list2));
        printLinkedList(reverseList(list3));
    }
}
