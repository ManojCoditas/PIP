/**
 * Input: head = [1, 2, 3, 4, 5], k = 3
 * Expected Output: [3, 2, 1, 4, 5]
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class _3_Reverse_K_Nodes_in_a_LinkedList {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        while (current != null) {
            ListNode groupStart = current;
            int count = 0;
            while (current != null && count < k) {
                current = current.next;
                count++;
            }

            if (count == k) {
                ListNode prev = null;
                ListNode next = null;
                ListNode groupEnd = groupStart;
                for (int i = 0; i < k; i++) {
                    next = groupStart.next;
                    groupStart.next = prev;
                    prev = groupStart;
                    groupStart = next;
                }

                prevGroupEnd.next = prev;
                groupEnd.next = current;

                prevGroupEnd = groupEnd;
            }
        }

        return dummy.next;
    }

    public static ListNode createList(int[] values) {
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        _3_Reverse_K_Nodes_in_a_LinkedList solution = new _3_Reverse_K_Nodes_in_a_LinkedList();

        // Input: [1, 2, 3, 4, 5], k = 3
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = createList(values);

        System.out.print("Original List: ");
        printList(head);

        ListNode newHead = solution.reverseKGroup(head, 3);

        System.out.print("Reversed List: ");
        printList(newHead);
    }
}

