public class q1 {

    private String[] items;
    private int top; // Index of the top element

    public q1(int capacity) {
        this.items = new String[capacity];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == items.length - 1;
    }

    public void push(String item) {
        if (isFull()) {
            throw new RuntimeException("Stack overflow");
        }
        items[++top] = item;
        System.out.println("Pushed element: " + item);
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        String poppedItem = items[top--];
        System.out.println("Popped element: " + poppedItem);
        return poppedItem;
    }

    public String peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return items[top];
    }

    public void swapTopAndBottom() {
        if (isEmpty() || top < 1) {
            System.out.println("Swap not possible: Stack has less than 2 elements");
            return;
        }
        String temp = items[top];
        items[top] = items[0];
        items[0] = temp;
        System.out.println("Swapped top (" + items[top] + ") and bottom (" + items[0] + ") elements");
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(items[i]);
        }
    }

    public static void main(String[] args) {
        q1 stack = new q1(10);

        // Push 10 strings
        for (int i = 0; i < 10; i++) {
            stack.push("String " + (i + 1));
        }
        stack.printStack(); // Print current state

        // Delete 4 elements
        for (int i = 0; i < 4; i++) {
            stack.pop();
        }
        stack.printStack(); // Print after deleting 4 elements

        // Swap last element to first
        stack.swapTopAndBottom();
        stack.printStack(); // Print after swapping
    }
}
