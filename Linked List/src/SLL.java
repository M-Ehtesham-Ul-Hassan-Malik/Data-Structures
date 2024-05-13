class singlyLL{
    Node head;
    Node tail;

    int size;

    public singlyLL() {
        this.size = 0;
    }

    class Node {
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

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail==null){
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
    public void insert(int val, int idx){
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

    public int deleteFirst(){
        int val = head.val;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size --;
        return val;
    }
    public int deleteLast(){
        if (size <= 1){
            return deleteFirst();
        }

        Node current = head;
        Node previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        int val = tail.val;
        if (previous != null) {
            previous.next = null;
            tail = previous;
        } else {
            head = null;
            tail = null;
        }
        size--;
        return val;
    }

    public int delete(int idx){
        if (idx == 0){
            return deleteFirst();
        }
        if (idx == size -1){
            return deleteLast();
        }
        Node prev = get(idx -1);
        int val = prev.next.val;
        prev.next = prev.next.next;
        size --;
        return val;
    }

    public Node get(int idx){
        Node node = head;
        for (int i = 0; i <idx ; i++) {
            node = node.next;
        }
        return node;
    }

    public void display(){
        Node temp = head;
        while (temp!=null){
            System.out.print(temp.val +" --> ");
            temp = temp.next;
        }
        System.out.print("End");
        System.out.println();
    }



}
public class SLL{
    public static void main(String[] args) {
        singlyLL sll = new singlyLL();
        sll.insertFirst(22);
        sll.insertFirst(25);
        sll.insertFirst(3);
        sll.insertFirst(5);
        sll.insertFirst(7);
        sll.insertFirst(9);

        //now inserting in the last in this LL (9 --> 7 --> 5 --> 3)
        sll.insertLast(11);

        //now inserting the value 13 at particular index i.e: 3
        sll.insert(13,3);

        //now deleting the first value from LL
        sll.display(); //before deletion
        System.out.println("Deleting first node:");
        System.out.println(sll.deleteFirst());//display deleted element

        //now deleting the first value from LL
        sll.display(); //before deletion
        System.out.println("Deleting last node:");
        System.out.println(sll.deleteLast());
        System.out.println();

        sll.display();
        sll.delete(3);
        sll.display();

    }
}