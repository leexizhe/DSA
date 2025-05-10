package answers.f_linked_list;

import java.util.HashMap;

public class F6CopyListWithRandomPointer {
    /**
     * Time Complexity: O(n)
     * The time complexity of this solution is O(n), where n is the number of nodes in the linked list.
     * We iterate through the list twice—first to create node mappings, second to update pointers.
     *
     * Space Complexity: O(n)
     * The space complexity is O(n), since we store mappings of original to copied nodes in a HashMap.
     */
    public static ListNode copyRandomList(ListNode head) {
        if (head == null) return null;

        HashMap<ListNode, ListNode> map = new HashMap<>();

        // First pass: Create new nodes and store mappings
        ListNode current = head;
        while (current != null) {
            map.put(current, new ListNode(current.val));
            current = current.next;
        }

        // Second pass: Set next and random pointers
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print("[" + current.val + ", Random: " + (current.random != null ? current.random.val : "null")
                    + "] -> ");
            current = current.next;
        }
        System.out.println("null");
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

        System.out.println("Original List:");
        printList(head);

        ListNode copiedHead = copyRandomList(head);
        System.out.println("Copied List:");
        printList(copiedHead);
    }
}
