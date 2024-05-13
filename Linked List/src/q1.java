import java.util.LinkedList;

class Node {
    public int data;
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
public class q1 {
    public static void main(String[] args) {
        linklist list = new linklist();
        list.insert(1);
        list.insert(2);
        list.insert(3);

        list.display();
    }

    static class linklist {
        Node head;
        Node tail;

        int size;

        public void insert(int val) {
            Node node = new Node(val);
            node.next = head;
            head = node;

            if (tail == null) {
                tail = head;
            }
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.val + " --> ");
                temp = temp.next;
            }
            System.out.print("End");
            System.out.println();
        }


    }
}