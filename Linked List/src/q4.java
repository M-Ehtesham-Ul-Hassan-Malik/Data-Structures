import java.util.LinkedList;

class Node3 {
    int val;
    Node next;

    public Node3 (int val) {
        this.val = val;
    }

    public Node3(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
public class q4 {
    public static void main(String[] args) {
        linklist list = new linklist();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertLast(22);
        list.display();
        System.out.println("inserting '5' at index 2:");
        list.insertIndex(5,2);
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

        public void insertLast(int val){
            if (tail==null){
                insertFirst(val);
                return;
            }
            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size++;
        }


        public void insertIndex(int val, int idx){
            if (idx == 0){
                insertFirst(val);
                return;
            }
            if (idx == size){
                insertLast(val);
                return;
            }

            Node temp = head;
            for (int i = 1; i <idx ; i++) {
                temp = temp.next;
            }
            Node node = new Node(val,temp.next);
            temp.next = node;
            size++;

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