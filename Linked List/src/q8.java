class Node7 {
    int data;
    Node next;

    // Constructor
    Node7(int data) {
        this.data = data;
        this.next = null;
    }
}

public class q8 {
    Node head;

    // Constructor
    q8() {
        this.head = null;
    }

    // Function to add a node at the end of the linked list
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Function to reverse a linked list
    private Node reverseLinkedList(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    // Function to find the middle of a linked list
    private Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to check if a linked list is a palindrome
    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return true; // Empty list or single node is considered a palindrome
        }

        // Find the middle of the linked list
        Node middleNode = findMiddle(head);

        // Reverse the second half of the linked list
        Node reversedSecondHalf = reverseLinkedList(middleNode);

        // Compare the first half with the reversed second half
        Node current1 = head;
        Node current2 = reversedSecondHalf;
        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false; // Not a palindrome
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return true; // Palindrome
    }

    public static void main(String[] args) {
        q8 list = new q8();

        // Add nodes to the linked list
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(3);
        list.addNode(2);
        list.addNode(1);

        // Check if the linked list is a palindrome
        if (list.isPalindrome()) {
            System.out.println("Linked list is a palindrome.");
        } else {
            System.out.println("Linked list is not a palindrome.");
        }
    }
}
