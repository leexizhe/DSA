package answers.f_linked_list;

import static answers.f_linked_list.PrintLinkedList.printLinkedList;

import java.util.PriorityQueue;

public class F10MergeKSortedLists {
    /**
     * Time Complexity: O(N log K)
     * The time complexity of this solution is O(N log K), where K is the number of linked lists
     * and N is the total number of nodes across all lists. Each insertion and removal operation in
     * the priority queue takes O(log K), and we perform these operations for all N nodes.
     *
     * Space Complexity: O(K)
     * The space complexity is O(K), as we store at most K elements in the priority queue.
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-Heap (Priority Queue) to track the smallest node from each list
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        // Add the head of each non-empty linked list to the heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        // Process the heap until empty
        while (!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            tail.next = smallest;
            tail = smallest;

            // If there's a next node, push it into the heap
            if (smallest.next != null) {
                minHeap.offer(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        System.out.println("Merged Sorted List:");
        printLinkedList(mergeKLists(lists));
    }
}
