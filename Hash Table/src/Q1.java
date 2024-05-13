class Node {
    int key;
    Node next;

    public Node(int key) {
        this.key = key;
        this.next = null;
    }
}

// Hash table class
class HashTable {
    private Node[] table;
    private int size;

    // Constructor to initialize the hash table
    public HashTable(int size) {
        this.size = size;
        this.table = new Node[size];
    }

    // Hash function to calculate index for a given key
    private int hashFunction(int key) {
        return key % size;
    }

    // Method to insert a key into the hash table
    public void insert(int key) {
        int index = hashFunction(key);
        Node newNode = new Node(key);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            // Collision handling: Append to the end of the linked list
            Node current = table[index];
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to search for a key in the hash table
    public boolean search(int key) {
        int index = hashFunction(key);
        Node current = table[index];

        while (current != null) {
            if (current.key == key) {
                return true; // Found the key
            }
            current = current.next;
        }

        return false; // Key not found
    }

    // Method to delete a key from the hash table
    public void delete(int key) {
        int index = hashFunction(key);
        Node current = table[index];
        Node prev = null;

        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            // Key not found
            return;
        }

        if (prev == null) {
            // If the key to be deleted is the head of the linked list
            table[index] = current.next;
        } else {
            // Remove current node from the linked list
            prev.next = current.next;
        }
    }
}

// Main class to demonstrate hash table operations
public class Q1 {
    public static void main(String[] args) {
        int[] keys = {20, 34, 45, 70, 56};
        HashTable hashTable = new HashTable(10); // Choose hash table size (e.g., 10)

        // Insert elements into the hash table
        for (int key : keys) {
            hashTable.insert(key);
        }

        // Search for elements in the hash table
        System.out.println("Searching for elements:");
        System.out.println("Key 20 found? " + hashTable.search(20));
        System.out.println("Key 45 found? " + hashTable.search(45));
        System.out.println("Key 100 found? " + hashTable.search(100));

        // Delete an element from the hash table
        System.out.println("\nDeleting element with key 45...");
        hashTable.delete(45);
        System.out.println("Key 45 found? " + hashTable.search(45));
    }
}
