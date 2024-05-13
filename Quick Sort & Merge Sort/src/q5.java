class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class q5 {

    public ListNode mergeSort(ListNode head) {
        // Base case: If the list is empty or has only one node, it is already sorted
        if (head == null || head.next == null) {
            return head;
        }

        // Split the list into two halves using slow and fast pointers
        ListNode[] split = splitList(head);
        ListNode left = split[0];
        ListNode right = split[1];

        // Recursively sort each half
        left = mergeSort(left);
        right = mergeSort(right);

        // Merge the sorted halves
        return merge(left, right);
    }

    // Helper method to split the list into two halves
    private ListNode[] splitList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) {
            prev.next = null; // Split the list into two at the middle
        }

        return new ListNode[] { head, slow };
    }

    // Helper method to merge two sorted linked lists
    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // Append the remaining nodes of left or right list
        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }

    // Helper method to print the linked list
    private void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a sample linked list: 4 -> 2 -> 1 -> 3 -> 5
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        q5 sorter = new q5();

        System.out.println("Original Linked List:");
        sorter.printList(head);

        // Sort the linked list using Merge Sort
        ListNode sortedHead = sorter.mergeSort(head);

        System.out.println("Sorted Linked List:");
        sorter.printList(sortedHead);
    }
}
