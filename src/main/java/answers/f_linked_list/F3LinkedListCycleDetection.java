package answers.f_linked_list;

import java.util.HashSet;

public class F3LinkedListCycleDetection {

    /**
     * Key Techniques:
     * ✅ Floyd’s Cycle Detection Algorithm → Efficient for detecting cycles.
     * ✅ O(n) Time Complexity → Only requires a single pass.
     * ✅ O(1) Space Complexity → No extra memory usage.
     *
     * Time Complexity: O(n)
     * We traverse the linked list once, making it linear in time.
     *
     * Space Complexity: O(1)
     * Since we only use two pointers, we require constant extra space.
     */
    private static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer one step
            fast = fast.next.next; // Move fast pointer two steps

            if (slow == fast) return true; // Cycle detected
        }

        return false; // No cycle found
    }

    /**
     * Key Techniques:
     * ✅ HashSet for Tracking → Detects cycles by storing visited nodes.
     * ✅ O(n) Time Complexity → Traverses the list once.
     * ✅ O(n) Space Complexity → Uses extra memory proportional to the list size.
     *
     * Time Complexity: O(n)
     * We iterate through the linked list, storing each node, making it linear in time.
     *
     * Space Complexity: O(n)
     * We store up to n nodes in the HashSet, leading to linear space usage.
     */
    public static boolean hasCycle2(ListNode head) {
        // Step 1: Edge case - If the list is empty, return false
        if (head == null) return false;

        // Step 2: Initialize a HashSet to track visited nodes
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = head;

        // Step 3: Traverse the linked list
        while (node != null) {
            // Step 4: If the node has already been seen, a cycle exists
            if (set.contains(node)) return true;

            // Step 5: Add the current node to the HashSet and move to the next
            set.add(node);
            node = node.next;
        }

        // Step 6: If traversal completes without finding duplicates, no cycle exists
        return false;
    }

    public static void main(String[] args) {
        ListNode cycleNode = new ListNode(3);
        ListNode head1 = new ListNode(1, new ListNode(2, cycleNode));
        cycleNode.next = head1; // Creates cycle

        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3)));

        System.out.println(hasCycle(head1)); // Output: true
        System.out.println(hasCycle(head2)); // Output: false

        System.out.println(hasCycle2(head1)); // Output: true
        System.out.println(hasCycle2(head2)); // Output: false
    }
}
