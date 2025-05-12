package answers.f_linked_list;

import static answers.f_linked_list.PrintLinkedList.printLinkedList;

public class F7AddTwoNumbers {
    /**
     * Key Techniques:
     * ✅ Linked List Traversal → Processes both numbers efficiently.
     * ✅ Carry Management → Handles sum overflow beyond single digits.
     * ✅ O(n) Time Complexity → Traverses both linked lists in one pass.
     *
     * Time Complexity: O(n)
     * We iterate through both linked lists once, making the solution linear in time.
     *
     * Space Complexity: O(n)
     * The result list stores a new set of nodes for the sum.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Placeholder node for result
        ListNode curr = dummy;
        int carry = 0;

        // Step 1: Traverse both lists while handling carry
        while (l1 != null || l2 != null || carry > 0) {
            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            carry = sum / 10; // Extract carry for next digit
            curr.next = new ListNode(sum % 10); // Store current digit
            curr = curr.next;
        }

        return dummy.next; // Head of the resulting sum list
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println("Sum List:");
        printLinkedList(addTwoNumbers(l1, l2)); // Output: 7 → 0 → 8
    }
}
