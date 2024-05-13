public class q6 {
    Node head;
    Node tail;

    q6() {
        this.head = null;
        this.tail = null;
    }

    public boolean nodeExists(int key) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void updateNodeData(int key, int newData) {
        Node current = head;
        while (current != null) {
            if (current.data == key) {
                current.data = newData;
                return;
            }
            current = current.next;
        }
    }

    public void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("End");
        System.out.println();
    }

    public static void main(String[] args) {
        q6 list = new q6();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.insert(6);
        list.insert(7);
        System.out.println("Displaying the original Linked List");
        list.display();
        int key = 5;
        if (list.nodeExists(key)) {
            // Update the node data from 5 to 6
            int newData = 6;
            list.updateNodeData(key, newData);
            System.out.println("Linked list after updating node " + key + " to " + newData + ":");
            // Display the updated list
            list.display();
        } else {
            System.out.println("Key " + key + " does not exist.");
        }
    }
}
