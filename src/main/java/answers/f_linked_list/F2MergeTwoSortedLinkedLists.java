package answers.f_linked_list;

import static answers.f_linked_list.PrintLinkedList.printLinkedList;

public class F2MergeTwoSortedLinkedLists {
    /**
     * Time Complexity: O(n + m)
     * The time complexity of this solution is O(n + m), where n and m are the number of nodes in the two linked lists.
     * This is because we traverse both lists once to merge them.
     *
     * Space Complexity: O(1)
     * The space complexity of this solution is O(1), since we modify the original lists without using additional storage.
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1); // Dummy node to simplify merging logic
        ListNode current =
                dummy; // Using dummy.next, we return the merged list without worrying about tracking the head manually

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        current.next = (l1 != null) ? l1 : l2;

        return dummy.next; // Return merged list without dummy node
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        printLinkedList(mergeTwoLists(list1, list2)); // Output: 1 -> 1 -> 2 -> 3 -> 4 -> 4
    }
}
