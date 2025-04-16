package answers.f_linked_list;

public class F1ReverseLinkedList {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of nodes in the linked list.
     * This is because we traverse the entire list once to reverse the pointers.
     *
     * Space Complexity: O(1)
     * The space complexity of this solution is O(1), as we reverse the list in place without using additional storage.
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

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder();

        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        System.out.println(sb);
    }
}
