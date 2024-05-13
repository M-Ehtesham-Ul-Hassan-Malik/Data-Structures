public class Q5 {

    private static final int TABLE_SIZE = 11;
    private static int[] hashTable = new int[TABLE_SIZE];

    // Hash function f(x) = (5x + 4) % 11
    private static int hashFunction(int x) {
        return (5 * x + 4) % TABLE_SIZE;
    }

    // Insert value into the hash table using linear probing
    private static void insert(int value) {
        int index = hashFunction(value);

        while (hashTable[index] != 0) {
            index = (index + 1) % TABLE_SIZE; // Linear probing to find next available slot
        }

        hashTable[index] = value;
    }

    // Display the final positions of values in the hash table
    private static void displayHashTable() {
        System.out.println("Final Positions in the Hash Table:");
        for (int i = 0; i < TABLE_SIZE; i++) {
            if (hashTable[i] != 0) {
                System.out.println("Index " + i + ": " + hashTable[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] values = {3, 9, 2, 1, 14, 6, 25};

        // Insert values into the hash table
        for (int value : values) {
            insert(value);
        }

        // Display the final positions of values in the hash table
        displayHashTable();
    }
}
