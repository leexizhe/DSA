package answers.f_linked_list;

import static answers.f_linked_list.PrintLinkedList.printLinkedList;

public class F7AddTwoNumbers {
    /**
     * Time Complexity: O(max(m, n))
     * The time complexity of this solution is O(max(m, n)), where m and n are the lengths of the two input linked lists.
     * We traverse both lists simultaneously, performing O(1) operations per node.
     *
     * Space Complexity: O(max(m, n))
     * The space complexity is O(max(m, n)) as we store the result in a new linked list of similar size.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to simplify result list creation
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10; // Compute carry for the next digit
            current.next = new ListNode(sum % 10); // Store the last digit of the sum
            current = current.next;

            // Move to the next node in the input lists
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next; // Return head of the resulting sum list
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println("Input List 1:");
        printLinkedList(l1);
        System.out.println("Input List 2:");
        printLinkedList(l2);

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println("Sum List:");
        printLinkedList(result);
    }
}
