package answers.f_linked_list;

import static answers.f_linked_list.PrintLinkedList.printLinkedList;

import java.util.PriorityQueue;

public class F10MergeKSortedLists {
    /**
     * Key Techniques:
     * ✅ Min-Heap (PriorityQueue) → Efficiently retrieves smallest node.
     * ✅ O(n log k) Time Complexity → Processes k lists efficiently.
     * ✅ O(k) Space Complexity → Stores at most k nodes in the heap.
     *
     * Time Complexity: O(n log k)
     * Extracting elements from a heap costs log k operations per node.
     *
     * Space Complexity: O(k)
     * Heap stores k nodes, reducing memory overhead.
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Step 1: Add all non-null heads to heap
        for (ListNode list : lists) {
            if (list != null) minHeap.add(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Step 2: Extract min node, add next node from extracted list
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            curr.next = smallest;
            curr = curr.next;

            if (smallest.next != null) minHeap.add(smallest.next);
        }

        return dummy.next;
    }

    /**
     * Alternative Divide & Conquer Approach:
     * ✅ Reduces problem size iteratively.
     * ✅ O(n log k) complexity similar to heap method.
     */
    public static ListNode mergeKListsDivideAndConquer(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        return mergeListsHelper(lists, 0, lists.length - 1);
    }

    private static ListNode mergeListsHelper(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];

        int mid = left + (right - left) / 2;
        ListNode l1 = mergeListsHelper(lists, left, mid);
        ListNode l2 = mergeListsHelper(lists, mid + 1, right);

        return mergeTwoLists(l1, l2);
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = {
            new ListNode(1, new ListNode(4, new ListNode(5))),
            new ListNode(1, new ListNode(3, new ListNode(4))),
            new ListNode(2, new ListNode(6))
        };

        System.out.println("Merged List:");
        printLinkedList(mergeKLists(lists));
        printLinkedList(mergeKListsDivideAndConquer(lists));
    }
}
