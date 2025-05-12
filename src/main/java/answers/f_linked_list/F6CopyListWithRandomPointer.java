package answers.f_linked_list;

import static answers.f_linked_list.PrintLinkedList.printLinkedList;

import java.util.HashMap;

public class F6CopyListWithRandomPointer {
    /**
     * Key Techniques:
     * ✅ Hash Map for Node Mapping → Tracks original to copied nodes.
     * ✅ Two-Pass Approach → Ensures correct structure and random pointer mapping.
     * ✅ O(n) Time Complexity → Processes all nodes efficiently.
     *
     * Time Complexity: O(n)
     * We traverse the linked list twice (once for copying nodes, once for linking).
     *
     * Space Complexity: O(n)
     * Extra memory used for storing node mappings in a hash map.
     */
    public static ListNode copyRandomList(ListNode head) {
        if (head == null) return null;

        HashMap<ListNode, ListNode> map = new HashMap<>();

        // Step 1: Clone all nodes and store in map
        ListNode curr = head;
        while (curr != null) {
            map.put(curr, new ListNode(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers using the map
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head); // Return cloned head
    }

    /**
     * Alternative Optimized Approach: In-place modification without extra space
     * ✅ Reduces space complexity to O(1) by modifying original structure.
     */
    public static ListNode copyRandomListOptimized(ListNode head) {
        if (head == null) return null;

        // Step 1: Insert cloned nodes next to original nodes
        ListNode curr = head;
        while (curr != null) {
            ListNode copy = new ListNode(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Assign random pointers
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Detach the cloned list from the original list
        curr = head;
        ListNode dummy = new ListNode(0);
        ListNode copyHead = dummy, copy;
        while (curr != null) {
            copy = curr.next;
            curr.next = copy.next;
            copyHead.next = copy;
            copyHead = copy;
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        printLinkedList(copyRandomListOptimized(head));
    }
}
