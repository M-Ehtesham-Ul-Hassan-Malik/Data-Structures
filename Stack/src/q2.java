class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        front = null;
        rear = null;
    }

    // Node class to represent elements in the queue
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Enqueue: add element to the end of the queue
    public void enqueue(Order element) {
        Node newNode = new Node(element);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue: remove element from the front of the queue
    public Order dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int dequeuedItem = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return dequeuedItem;
    }

    // Front: retrieve the front element without removal
    public int front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return front.data;
    }

    // isEmpty: check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}

class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    // Node class to represent elements in the stack
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Push: add element to the top of the stack
    public void push(int element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
    }

    // Pop: remove and return element from the top of the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int poppedItem = top.data;
        top = top.next;
        return poppedItem;
    }

    // Peek: return element from the top of the stack without removal
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    // isEmpty: check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}
public class q2 {
    public static void main(String[] args) {
        // Test Queue
        Queue queue = new Queue();

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Dequeue and print elements
        while (!queue.isEmpty()) {
            System.out.println("Front element: " + queue.front());
            System.out.println("Dequeued element: " + queue.dequeue());
        }

        // Test Stack
        Stack stack = new Stack();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Pop and print elements
        while (!stack.isEmpty()) {
            System.out.println("Top element: " + stack.peek());
            System.out.println("Popped element: " + stack.pop());
        }
    }
}

