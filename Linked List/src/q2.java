class Node1 {
    int val;
    Node next;

    public Node1(int val) {
        this.val = val;
    }
}

public class q2 {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);

        list.display();
    }

    static class LinkList {
        Node head;
        Node tail;
        int size;

        public LinkList() {
            head = null;
            tail = null;
            size = 0;
        }

        public void insertLast(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " --> ");
                temp = temp.next;
            }
            System.out.println("End");
        }
    }
}
