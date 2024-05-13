import java.util.Scanner;

class Node {
    Order data;
    Node next;

    public Node(Order data) {
        this.data = data;
        this.next = null;
    }
}

class Queue1 {
    private Node front;
    private Node rear;

    public Queue1() {
        front = null;
        rear = null;
    }

    public void enqueue(Order order) {
        Node newNode = new Node(order);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public Order dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Order dequeuedItem = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return dequeuedItem;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public Order peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        Node current = front;
        System.out.println("Current orders in the queue:");
        while (current != null) {
            System.out.println("Order #" + current.data.getOrderId() + " for " + current.data.getCustomerName() +
                    ", Product: " + current.data.getProductName());
            current = current.next;
        }
    }
}

class Order {
    private int orderId;
    private String customerName;
    private String productName;

    public Order(int orderId, String customerName, String productName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.productName = productName;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }
}

public class q4 {
    private Queue orderQueue;

    public q4() {
        orderQueue = new Queue();
    }

    public void addOrder(Order order) {
        orderQueue.enqueue(order);
        System.out.println("Order #" + order.getOrderId() + " added to the queue.");
    }

    public void processNextOrder() {
        Order order = orderQueue.dequeue();
        if (order != null) {
            System.out.println("Processing Order #" + order.getOrderId() + " for " + order.getCustomerName() +
                    ", Product: " + order.getProductName());
        } else {
            System.out.println("No orders in the queue to process.");
        }
    }

    public void skipCancelledOrders() {
        Queue tempQueue = new Queue();
        int skipped = 0;
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.dequeue();
            if (!order.getProductName().equalsIgnoreCase("cancel")) {
                tempQueue.enqueue(order);
            } else {
                skipped++;
            }
        }
        orderQueue = tempQueue;
        System.out.println(skipped + " cancelled orders skipped.");
    }

    public void displayCurrentOrder() {
     /*   Order currentOrder = orderQueue.peek();
        if (currentOrder != null) {
            System.out.println("Current Order: #" + currentOrder.getOrderId() + " for " +
                    currentOrder.getCustomerName() + ", Product: " + currentOrder.getProductName());
        } else {
            System.out.println("No orders in the queue.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        q4 orderProcessing = new q4();

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add New Order");
            System.out.println("2. Process Next Order");
            System.out.println("3. Skip Cancelled Orders");
            System.out.println("4. Display Current Order");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Order ID: ");
                    int orderId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    Order newOrder = new Order(orderId, customerName, productName);
                    orderProcessing.addOrder(newOrder);
                    break;
                case 2:
                    orderProcessing.processNextOrder();
                    break;
                case 3:
                    orderProcessing.skipCancelledOrders();
                    break;
                case 4:
                    orderProcessing.displayCurrentOrder();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }
}
