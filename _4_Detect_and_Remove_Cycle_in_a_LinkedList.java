/*
Input: head = [1, 2, 3, 4, 5] //3->2->0->4-> back to 2
Expected Output: Cycle detected at node with value 2
after Removal []1,2,3,4,5]
* */


public class _4_Detect_and_Remove_Cycle_in_a_LinkedList {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public void removeCycle(ListNode head) {
        ListNode cycleStart = detectCycle(head);
        if (cycleStart == null) {
            System.out.println("No cycle");
            return;
        }

        ListNode temp = cycleStart;
        while (temp.next != cycleStart) {
            temp = temp.next;
        }
        temp.next = null;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next;

        _4_Detect_and_Remove_Cycle_in_a_LinkedList solution = new _4_Detect_and_Remove_Cycle_in_a_LinkedList();

        ListNode cycleStart = solution.detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle detected at node with value " + cycleStart.val);
            solution.removeCycle(head);
        }

        System.out.print("After removal: ");
        solution.printList(head);
    }
}

