
class Node6 {
    int data;
    Node next;

    // Constructor
    Node6(int data) {
        this.data = data;
        this.next = null;
    }

}

public class q7 {
    Node head;

    // Constructor
    q7() {
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

    // Function to rearrange the linked list such that all even numbers appear before odd numbers
    public void rearrangeEvenOdd() {
        if (head == null || head.next == null) {
            // List is empty or has only one node, no need to rearrange
            return;
        }

        Node evenHead = null;
        Node evenTail = null;
        Node oddHead = null;
        Node oddTail = null;

        Node current = head;
        while (current != null) {
            if (current.data % 2 == 0) { // even number
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = current;
                }
            } else { // odd number
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = current;
                }
            }
            current = current.next;
        }

        // Connect even numbers to odd numbers
        if (evenHead != null) {
            head = evenHead;
            evenTail.next = oddHead;
        } else {
            head = oddHead;
        }

        // Set the next of the last node to null to terminate the list
        if (oddTail != null) {
            oddTail.next = null;
        }
    }

    // Function to print the linked list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        q7 list = new q7();

        // Add nodes to the linked list
        list.addNode(17);
        list.addNode(15);
        list.addNode(8);
        list.addNode(12);
        list.addNode(10);
        list.addNode(5);
        list.addNode(4);
        list.addNode(1);
        list.addNode(7);
        list.addNode(6);

        System.out.println("Original linked list:");
        list.printList();

        // Rearrange the list such that even numbers appear before odd numbers
        list.rearrangeEvenOdd();

        System.out.println("Linked list after rearranging even and odd numbers:");
        list.printList();
    }
}
