import java.util.LinkedList;

class Node2 {
    int val;
    Node next;

    public Node2(int val) {
        this.val = val;
    }

}

public class q3 {
    public static void main(String[] args) {
        linklist list = new linklist();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);

        list.display();
    }

    static class linklist {
        Node head;
        Node tail;

        int size;

        public void insertFirst(int val) {
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