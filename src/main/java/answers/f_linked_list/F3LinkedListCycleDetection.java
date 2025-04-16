package answers.f_linked_list;

import java.util.HashSet;

public class F3LinkedListCycleDetection {

    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of nodes in the linked list.
     * This is because we traverse the list once using the slow and fast pointers.
     *
     * Space Complexity: O(1)
     * The space complexity of this solution is O(1), as we use only two pointers without extra storage.
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
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of nodes in the linked list.
     * This is because each node is visited once and stored in the HashSet before checking for duplicates.
     *
     * Space Complexity: O(n)
     * The space complexity of this solution is O(n), as we store each visited node in a HashSet.
     * In the worst case, all nodes are unique and must be stored.
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
