import java.util.EmptyStackException;

public class q3 {
    private Node top;

    public q3() {
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
            throw new EmptyStackException();
        }
        int poppedItem = top.data;
        top = top.next;
        return poppedItem;
    }

    // Peek: return element from the top of the stack without removal
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // isEmpty: check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Insert element at the bottom of the stack
    public void insertAtBottom(int element) {
        if (isEmpty()) {
            push(element);
        } else {
            // Create an auxiliary stack
            Stack tempStack = new Stack();
            // Push all elements from current stack to auxiliary stack
            while (!isEmpty()) {
                tempStack.push(pop());
            }
            // Push the new element to the top of the current stack
            push(element);
            // Push back all elements from the auxiliary stack to the current stack
            while (!tempStack.isEmpty()) {
                push(tempStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        q3 stack = new q3();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Insert 40 at the bottom
        stack.insertAtBottom(40);

        // Pop and print elements
        while (!stack.isEmpty()) {
            System.out.println("Top element: " + stack.peek());
            System.out.println("Popped element: " + stack.pop());
        }
    }
}
