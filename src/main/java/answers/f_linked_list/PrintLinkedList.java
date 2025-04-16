package answers.f_linked_list;

public class PrintLinkedList {
    private PrintLinkedList() {}

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
